package ru.geekbrains.java;

import java.util.Objects;

//Класс для работы с котами
public class Cat {
    private String name;
    private int age;
    private String color;

    public Cat(String catName, int catAge, String catColor){
        this.name = catName;
        this.age = catAge;
        this.color = catColor;
    }

    @Override
    public String toString() {
        return String.format("%s-%d-%s", name, age, color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return name.equals(cat.name) && age == cat.age && color.equals(cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, color);
    }

    
}
