package ru.geekbrains.java;

import java.util.HashSet;

public class HomeWork06 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик", 1, "белый");
        Cat cat2 = new Cat("Муся", 2, "черный");
        Cat cat3 = new Cat("Рыжик", 3, "рыжий");
        Cat cat4 = new Cat("Барсик", 1, "белый");

        HashSet<Cat> hashSet = new HashSet<>();
        hashSet.add(cat1);
        hashSet.add(cat2);
        hashSet.add(cat3);
        hashSet.add(cat4);

        System.out.println("Проверка равенства котов 1 и 2 дала результат: " + cat1.equals(cat2));
        System.out.println("Проверка равенства котов 1 и 4 дала результат: " + cat1.equals(cat4));

        System.out.println(hashSet);
    }
    
}
