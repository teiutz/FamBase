package com.wad.firstmvc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate deadline;
    private String importance;
    private TaskType taskType;
    private boolean status;

    public Task(String name, String description, LocalDate deadline, String importance, TaskType taskType, User user) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.importance = importance;
        this.taskType = taskType;
        this.status = false;
        this.user = user;
    }
}
