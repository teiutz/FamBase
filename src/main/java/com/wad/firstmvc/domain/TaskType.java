package com.wad.firstmvc.domain;

public enum TaskType {
    HouseholdChores("Household Chores"), Errands("Errands"), FamilyNPersonal("Family & Personal"), HomeProjectsNMaintenance("Home Projects & Maintenance");

    private final String name;

    TaskType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}