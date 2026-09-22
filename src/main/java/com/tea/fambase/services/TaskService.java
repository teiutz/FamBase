package com.tea.fambase.services;

import com.tea.fambase.domain.Family;
import com.tea.fambase.domain.Task;
import com.tea.fambase.domain.TaskType;
import com.tea.fambase.domain.User;
import com.tea.fambase.repository.FamilyRepository;
import com.tea.fambase.repository.TaskRepository;
import com.tea.fambase.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final FamilyRepository familyRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository, FamilyRepository familyRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.familyRepository = familyRepository;
    }


    public List<Task> findAll() {
        return taskRepository.findAll();
    }


    public Task save(Task task) {
        return taskRepository.save(task);
    }


    public List<Task> findByStatus(boolean status) {
        return taskRepository.findByStatus(status);
    }


    public List<Task> findByImportance(String importance) {
        return taskRepository.findByImportance(importance);
    }

    public List<Task> findByTaskType(TaskType taskType) {
        return taskRepository.findByTaskType(taskType);
    }


    public Task findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }


    public void update(Task task) {
        taskRepository.save(task);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }

    public List<Task> findByUserFamily(Family family) {

        List<Task> tasks = new ArrayList<>();

        for (User user : userRepository.findAllByFamily(family)) {
            List<Task> userTasks = taskRepository.findAllByUser(user);
            tasks.addAll(userTasks);
        }

        return tasks;
    }
}
