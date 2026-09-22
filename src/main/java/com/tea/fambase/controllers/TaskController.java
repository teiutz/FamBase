package com.tea.fambase.controllers;

import com.tea.fambase.domain.Task;
import com.tea.fambase.domain.TaskType;
import com.tea.fambase.domain.User;
import com.tea.fambase.services.TaskService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String viewTasks(Model model, @AuthenticationPrincipal User currentUser) {
        model.addAttribute("tasks", taskService.findByUserFamily(currentUser.getFamily()));
        return "general/all";
    }

    @GetMapping("/new")
    public String showAddTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "tasks/addtasks";
    }

    @PostMapping("/new")
    public String addTask(Task task, @AuthenticationPrincipal User currentUser) {
        if (task.getId() == null) task.setId(new Random().nextLong());
        task.setUser(currentUser);
        taskService.save(task);
        return "redirect:/all";
    }


    @GetMapping("/delete")
    public String deleteTask(@RequestParam("id") String id, Model model) {
        Task task = taskService.findById(Long.parseLong(id));
        taskService.delete(task);
        return "redirect:/all";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Task task = taskService.findById(id);
        model.addAttribute("task", task);
        return "tasks/updatechores";
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute Task task) {
        taskService.update(task);
        return "redirect:/all";
    }


    @GetMapping("/alltasks")
    public String showEventsPage(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "tasks/chores";
    }

    @GetMapping("/grouped")
    public String showGroupedTasks(Model model) {
        model.addAttribute("household", taskService.findByTaskType(TaskType.HouseholdChores));
        model.addAttribute("errands", taskService.findByTaskType(TaskType.Errands));
        model.addAttribute("family", taskService.findByTaskType(TaskType.FamilyNPersonal));
        model.addAttribute("maintenance", taskService.findByTaskType(TaskType.HomeProjectsNMaintenance));
        return "tasks/groupedTasks";
    }
}
