package com.tea.fambase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Family {
    @OneToMany(mappedBy = "family")
    List<User> users = new ArrayList<>();
    @Setter
    @Id
    @GeneratedValue()
    private Long id;
    @Setter
    @Getter
    private String name;

    public Family() {
    }

    public Family(String name) {
        this.name = name;
    }
}
