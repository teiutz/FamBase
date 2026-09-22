package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.Family;
import com.wad.firstmvc.domain.Task;
import com.wad.firstmvc.domain.TaskType;
import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.repository.FamilyRepository;
import com.wad.firstmvc.repository.TaskRepository;
import com.wad.firstmvc.repository.UserRepository;
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
