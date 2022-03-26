package com.apollo.elegant.generics.pets.abs;

public abstract class Pet<T> {
    private T t;
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTName(T t) {
        return ((Pet<T>)t).getName();
    }
}
