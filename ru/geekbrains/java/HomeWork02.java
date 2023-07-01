package ru.geekbrains.java;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.*;

public class HomeWork02 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //Делаю "чтобы успеть", поэтому меню выбора задачи запилю по остаточному принципу
        boolean exitFlag = true;
        while(exitFlag){
            System.out.println("Выберите номер задачи:");
            System.out.println("1 - Задание 1 - Формирование sql запроса");
            System.out.println("2 - Задание 2 - Сортировка пузырьком с логгированием");
            System.out.println("0 - Завершение работы приложения");
            int no = HomeWork01.inputInteger("Введите целое число: ");
            System.out.println();

            switch(no){
                case 0:
                    System.out.println("Приложение остановлено");
                    exitFlag = false;
                break;
                case 1:
                    HW02_EX01();
                break;
                case 2:
                    HW02_EX02();
                break;
                default:
                    System.out.println("Некорректный номер задачи,повторите попытку ввода");
                break;
            }
        }       
    }

    static void HW02_EX01() {
        String request = "SELECT * FROM students WHERE";
        String filter = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        StringBuilder stringBuilder = new StringBuilder(request);

        String tmp = filter.replaceAll("[^a-zA-Z :]", "");
        String[] filterArr = (tmp.replaceAll(":", " ")).split(" ");

        int addNumber = 0;
        for(int i = 0; i < filterArr.length - 1; i= i + 2){
            if (filterArr[i+1].equals("null")) {
                break;
            }
            else {
                if (addNumber != 0) {
                    stringBuilder
                        .append(" AND");
                }
                addNumber++;
                stringBuilder
                    .append(" " + filterArr[i] + " = '" + filterArr[i + 1] + "'");
            }
        }
        System.out.print("Итоговый sql запрос:\n" + stringBuilder.toString() + "\n\n");
        
    }


    static void HW02_EX02() {
        System.out.println("Введите последовательность целых чисел через пробел");
        String sourceData = scanner.nextLine();
        //Принимаем, что пользователь продвинут и за ним проверять ввод нет необходимости
        String[] strData = sourceData.split(" ");
        int[] wrkData = new int[strData.length];
        for (int i=0; i<strData.length; i++) {
            wrkData[i] = Integer.parseInt(strData[i]);
        }

        int tmp = 0;
        boolean finish = false;
        Logger logger = Logger.getLogger(HomeWork02.class.getName());
        try{
            FileHandler fh = new FileHandler("log.xml");
            logger.addHandler(fh);
            XMLFormatter xml = new XMLFormatter();
            fh.setFormatter(xml);

            while (!finish) {
                finish = true;
                for (int i = 0; i < wrkData.length - 1; i++) {
                    if (wrkData[i] > wrkData[i + 1]){
                        tmp = wrkData[i + 1];
                        wrkData[i + 1] = wrkData[i];
                        wrkData[i] = tmp;
                        finish = false;
                    }
                }    
            logger.info(Arrays.toString(wrkData));
            }
        }
        catch(IOException ex){
            System.out.print("Ошибка логирования. Завершение приложения");
        }
        System.out.print("\nОтсортированный массив: " + Arrays.toString(wrkData) + "\n\n");
    }
}


