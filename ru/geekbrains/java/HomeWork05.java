package ru.geekbrains.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeWork05 {
    public static void main(String[] args) {
        String[] persons = {
            "Григорьев 452",
            "Фокин 152",
            "Шестаков 432",
            "Хохлов 252",
            "Фокин 452",
            "Брагина 433",
        };
        
        HashMap<String, List<Person>> telephones = new HashMap<>();
        for (String person : persons) {
            String[] personParts = person.split(" ");
            String studName = personParts[0];
            int studTel = Integer.parseInt(personParts[1]);
            Person per = new Person(studName, studTel);
            if (telephones.containsKey(studName)){
                telephones.get(studName).add(per);
            }
            else {
                ArrayList<Person> lst = new ArrayList<>();
                lst.add(per);
                telephones.put(studName, lst);
            }
        }

        Telephones.add("Иванов", 777, telephones);
        Telephones.get("Фокин", telephones);
    }


}
