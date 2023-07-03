package ru.geekbrains.java;

import java.util.ArrayList;
import java.util.Random;

public class HomeWork03 {
    static Random random = new Random();
    public static void main(String[] args) {
        ArrayList sourceArray =  creatingList();
        System.out.println("Исходный список: ");
        System.out.println(sourceArray);

        ArrayList delEvenArray = deletingEven(sourceArray);
        System.out.println("Список с удаленными четными числами: ");
        System.out.println(delEvenArray);

        minMax(delEvenArray);
        average(delEvenArray);

    }

    public static ArrayList creatingList(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int size = random.nextInt(1, 51);
        for (int i = 0; i < size; i++) {
            arrayList.add(random.nextInt(-100, 101));
        }

        return arrayList;
    }

    public static ArrayList<Integer> deletingEven(ArrayList<Integer> listEven){
        listEven.removeIf(i -> (i % 2 == 0));
        return listEven;
    }

    public static void minMax(ArrayList<Integer> listMinMax){
        int min = listMinMax.get(0);
        int max = listMinMax.get(0);
        for (int i = 1; i < listMinMax.size(); i++) {
            if (listMinMax.get(i) > max) {
                max = listMinMax.get(i);
            }
            if (listMinMax.get(i) < min) {
                min = listMinMax.get(i);
            }
        }
        System.out.printf("MAX значение списка без четных чисел = " + max + ", MIN = " + min + "\n");
    }

    public static void average(ArrayList<Integer> listAverage){
        float average = 0;
        float sum = 0;
        for (int i = 0; i < listAverage.size(); i++) {
            sum = sum + listAverage.get(i);
            //System.out.printf("sum" + sum + "\n");

        }
        average = sum / listAverage.size();
        System.out.printf("Среднее значение списка без четных чисел = %.2f", average);
    }



    
}
