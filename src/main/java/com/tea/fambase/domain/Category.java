package com.tea.fambase.domain;

public enum Category {
    FruitsNVeggies("Fruits & Veggies"), DairyNProtein("Dairy & Protein"), PantryNDryGoods("Pantry & Dry goods"), HouseholdNMiscellaneous("Household & Miscellaneous");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}