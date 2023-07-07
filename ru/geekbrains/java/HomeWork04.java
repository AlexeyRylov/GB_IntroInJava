package ru.geekbrains.java;

import java.util.LinkedList;

public class HomeWork04 {
    public static void main(String[] args) {
        //Задание 1
        LinkedList<Integer> initList = new LinkedList<>();
        initList.add(1);
        initList.add(2);
        initList.add(3);
        initList.add(4);
        initList.add(5);
        System.out.print("Исходный массив: " + initList + "\n");
        LinkedList<Integer> reverseList = task1(initList);
        System.out.print("Перевернутый массив: " + reverseList + "\n");

        //Задание 3
    }

    public static LinkedList<Integer> task1(LinkedList<Integer> initList){
        LinkedList<Integer> reverseList = new LinkedList<>();
        while (initList.size() > 0){
            reverseList.add(initList.getLast());
            initList.removeLast();
        }
        return reverseList;
    }
    
}
