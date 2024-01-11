package com.example.kckgui.Controller;

import com.example.kckgui.Model.Class.Task;
import com.example.kckgui.Model.Class.familyMember;
import com.example.kckgui.Model.Type.priorityType;
import com.example.kckgui.Model.Type.statusType;

import java.util.ArrayList;
import java.util.List;

public class taskController {

    private static ArrayList<Task> listOfTask = new ArrayList<>(DataTasks());

    public static void addTask(Task task){
        listOfTask.add(task);
    }

    public static void removeTask(int selected){
            listOfTask.remove(selected);
    }

    public static ArrayList<Task> getTasks() {
        return listOfTask;
    }

    public static List<Task> DataTasks(){
        List<Task> list = new ArrayList<>();

        list.add(new Task(1,"Utwórz prezentację", "Przygotuj prezentację dotyczącą nowego projektu", priorityType.WYSOKI, statusType.W_TOKU, new familyMember("Filip")));
        list.add(new Task(2,"Zakupy spożywcze", "Zakup potrzebnych artykułów spożywczych na ten tydzień", priorityType.PILNE, statusType.DO_ZROBIENIA, new familyMember("Mateusz")));
        list.add(new Task(3,"Raport miesięczny", "Przygotuj raport miesięczny z wyników działu sprzedaży", priorityType.SREDNI, statusType.WYKONANE, new familyMember("Patrycja")));
        list.add(new Task(4,"Przygotuj prezentację", "Utwórz prezentację dla klienta na jutrzejsze spotkanie", priorityType.WYSOKI, statusType.W_TOKU, new familyMember("Pawel")));
        list.add(new Task(5,"Ogród", "Zadbanie o ogród, przycięcie drzew i podlewanie kwiatów", priorityType.NISKI, statusType.DO_ZROBIENIA, new familyMember("Grzegorz")));
        list.add(new Task(6, "Sprzątanie domu", "Posprzątaj cały dom przed planowaną wizytą gości", priorityType.SREDNI, statusType.WYKONANE, new familyMember("Maciek")));
        list.add(new Task(7, "Rozwój umiejętności", "Zapisz się na kurs programowania w języku Java", priorityType.WYSOKI, statusType.W_TOKU, new familyMember("Ola")));
        list.add(new Task(8, "Wakacyjny wyjazd", "Zaplanuj wakacyjny wyjazd i zarezerwuj miejsca noclegowe", priorityType.NISKI, statusType.DO_ZROBIENIA, new familyMember("Sylwia")));
        list.add(new Task(9,"Zorganizuj urodziny", "Zaplanuj przyjęcie urodzinowe dla przyjaciela", priorityType.SREDNI, statusType.WYKONANE, new familyMember("Klaudia")));
        list.add(new Task(10,"Projekt aplikacji", "Rozpocznij pracę nad nowym projektem aplikacji mobilnej", priorityType.PILNE, statusType.W_TOKU, new familyMember("Piotr")));
        list.add(new Task(11,"Zorganizuj urodziny", "Zaplanuj przyjęcie urodzinowe dla przyjaciela", priorityType.SREDNI, statusType.WYKONANE, new familyMember("Klaudia")));


        return list;
    }

}
