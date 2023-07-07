package ru.geekbrains.java;

import java.util.logging.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class HomeWork01{
    static Scanner scanner = new Scanner(System.in);
    public static void  main(String[] args) {
        boolean exitFlag = true;
        while(exitFlag){
            System.out.println("Выберите номер задачи:");
            System.out.println("1 - Задание 1 - Вычисление n-го треугольного числа");
            System.out.println("2 - Задание 2 - Вывод простых чисел от 0 до 100");
            System.out.println("3 - Задание 3 - Калькулятор целых чисел");
            System.out.println("0 - Завершение работы приложения");
            //int no = Integer.parseInt(scanner.nextLine());
            int no = inputInteger("Введите целое число: ");
            System.out.println();

            switch(no){
                case 0:
                    System.out.println("Приложение остановлено");
                    exitFlag = false;
                    break;
                case 1:
                    HW01_EX01();
                    break;
                case 2:
                    HW01_EX02();
                    break;
                case 3:
                    HW01_EX03();
                    break;
                default:
                    System.out.println("Некорректный номер задачи,повторите попытку ввода");
                    break;
            }
        }
    }    

    static void HW01_EX01() {
        int hilim = inputInteger("Введите целое число: ");
        int result = 0;

        result = (int) triangleNum(hilim);
        System.out.printf("Результат: %d\n\n", result);
    }

    public static int inputInteger(String note) {
        int inputValue = 0;
        boolean inputOk = false;
        while (inputOk == false){
            System.out.printf("%s: ", note);
            String input = scanner.nextLine();
            try{
                inputValue = Integer.parseInt(input);
                inputOk = true;
                } catch (Exception e) {
                    System.out.println("Ошибка ввода, попробуйте еще раз");
                }
        }
        return inputValue;
    }

    static double triangleNum(int n) {
        if(n==1)return 1;
        return n + triangleNum(n-1);
    }

    static void HW01_EX02() {
        int hilim = 100;
        //известно, что 2 - простое, оно исключение из метода,
        //поэтому выведем вручную:
        System.out.print("Результат: 2 ");
        for (int i = 2; i <= hilim; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0){
                    break;
                }
                if (j == i-1) {
                    System.out.print(i + " ");
                }
            }
        }
        System.out.println("\n");    
    }

    static void HW01_EX03() {
        boolean exitFlag = true;
        Logger logger = Logger.getLogger(HomeWork01.class.getName());
        LinkedList<String> historyBuffer = new LinkedList<>();
        while(exitFlag){
            System.out.println("Выберите тип операции:");
            System.out.println("1 - Сложение");
            System.out.println("2 - Вычитание");
            System.out.println("3 - Умножение");
            System.out.println("4 - Деление");
            System.out.println("5 - UnDo");
            System.out.println("0 - Завершение расчета");
            int funcIndex = inputInteger("Введите целое число: ");
            int in1 = 0;
            int in2 = 0;
            int result = 0;
            boolean fhFirst = true;

            switch(funcIndex){
                case 0:
                    System.out.println("Калькулятор остановлен\n");
                    exitFlag = false;
                    break;
                case 1:
                    in1 = inputInteger("Введите первое целое число: ");
                    in2 = inputInteger("Введите второе целое число: ");
                    try{
                        FileHandler fh = new FileHandler("logAdd.xml");
                        logger.addHandler(fh);
                        XMLFormatter xml = new XMLFormatter();
                        fh.setFormatter(xml);
                        int calc = in1 + in2;
                        String res = "in1 + in2 = " + Integer.toString(calc); 
                        logger.info(res);
                        historyBuffer.add(res);
                        System.out.println();
                    }
                    catch(IOException ex){
                        System.out.print("Ошибка логирования. Завершение приложения");
                    }
                    break;
                case 2:
                    in1 = inputInteger("Введите первое целое число: ");
                    in2 = inputInteger("Введите второе целое число: ");
                    try{
                        FileHandler fh = new FileHandler("logSUB.xml");
                        logger.addHandler(fh);
                        XMLFormatter xml = new XMLFormatter();
                        fh.setFormatter(xml);
                        int calc = in1 - in2;
                        String res = "in1 - in2 = " + Integer.toString(calc); 
                        logger.info(res);
                        historyBuffer.add(res);
                        System.out.println();
                    }
                    catch(IOException ex){
                        System.out.print("Ошибка логирования. Завершение приложения");
                    }
                    break;
                case 3:
                    in1 = inputInteger("Введите первое целое число: ");
                    in2 = inputInteger("Введите второе целое число: ");
                    try{
                        FileHandler fh = new FileHandler("logMUL.xml");
                        logger.addHandler(fh);
                        XMLFormatter xml = new XMLFormatter();
                        fh.setFormatter(xml);
                        int calc = in1 * in2;
                        String res = "in1 * in2 = " + Integer.toString(calc); 
                        logger.info(res);
                        historyBuffer.add(res);
                        System.out.println();
                    }
                    catch(IOException ex){
                        System.out.print("Ошибка логирования. Завершение приложения");
                    }
                    break;
                case 4:
                    in1 = inputInteger("Введите первое целое число: ");
                    in2 = inputInteger("Введите второе целое число: ");
                    try{
                        FileHandler fh = new FileHandler("logDIV3.xml");
                        logger.addHandler(fh);
                        XMLFormatter xml = new XMLFormatter();
                        fh.setFormatter(xml);
                        if (in2 == 0) {
                            System.out.println("Увы, но на ноль делить нельзя\n");
                            break;
                        }
                        else {
                            int calc = in1 / in2;
                            String res = "in1 / in2 = " + Integer.toString(calc); 
                            logger.info(res);
                            historyBuffer.add(res);
                            System.out.println();
                        }
                    }
                    catch(IOException ex){
                        System.out.print("Ошибка логирования. Завершение приложения");
                    }
                    if (in2 == 0) {
                        System.out.println("Увы, но на ноль делить нельзя\n");
                        break;
                    }
                    else {
                        System.out.printf("Результат: %d\n\n", in1 / in2); 
                    }
                    break;
                case 5:
                    if (historyBuffer.size() >= 2) {
                        historyBuffer.removeLast();
                        System.out.printf("Предыдущий расчет: " + historyBuffer.getLast() + "\n\n");
                    }
                    else {
                        System.out.printf("Буфер истории пуст.\n\n");
                    }
                    break;
                default:
                    System.out.println("Некорректный номер операции,повторите попытку ввода");
                    break;
            }
        }
    }

}
