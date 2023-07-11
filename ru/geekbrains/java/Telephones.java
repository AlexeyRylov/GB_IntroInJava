package ru.geekbrains.java;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Telephones {

    private static HashMap<String, List<Person>> hashMap = new HashMap<>();
    private static String studName;
    private static int studTel;

    public static void add(String newPersonName, int newPersonTel, HashMap<String, List<Person>> telephones){
        hashMap = telephones;
        studName = newPersonName;
        studTel = newPersonTel;
        Person per = new Person(studName, studTel);
        if (hashMap.containsKey(studName)){
            hashMap.get(studName).add(per);
        }
        else {
                ArrayList<Person> lst = new ArrayList<>();
                lst.add(per);
                telephones.put(studName, lst);
        }
        
    }

    public static void get(String personName, HashMap<String, List<Person>> telephones){
        hashMap = telephones;
        studName = personName;
        for (HashMap.Entry<String, List<Person>> person :  hashMap.entrySet()){
            if (person.getKey().equals(studName))
                System.out.println(person.getValue());
        }
    }

}