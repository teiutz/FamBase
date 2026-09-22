package com.tea.fambase.repository;

import com.tea.fambase.domain.Task;
import com.tea.fambase.domain.TaskType;
import com.tea.fambase.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Task save(Task task);

    List<Task> findByStatus(boolean status);
    List<Task> findByImportance(String importance);
    List<Task> findByTaskType(TaskType taskType);

    List<Task> findAllByUser(User user);


}