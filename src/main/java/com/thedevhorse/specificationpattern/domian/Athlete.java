package com.thedevhorse.specificationpattern.domian;

import java.util.Arrays;

public class Athlete {

    private String athleteId;

    private String name;

    private int age;

    private Category category;

    private Athlete(String athleteId,
                    String name,
                    int age) {
        this.athleteId = athleteId;
        this.name = name;
        this.age = age;
        setCategory(age);
    }

    public static Athlete create(final String athleteId,
                                 final String name,
                                 final int age) {
        return new Athlete(
                athleteId,
                name,
                age
        );
    }

    public String athleteId(){
        return athleteId;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public Category category() {
        return category;
    }

    public Athlete changeCategory(int age) {
        setCategory(age);
        return this;
    }

    private void setCategory(int age) {
        this.category = Arrays.stream(Category.values())
                .filter(c -> age >= c.minAge() && age <= c.maxAge())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Category not found for the age: " + age));
    }
}
