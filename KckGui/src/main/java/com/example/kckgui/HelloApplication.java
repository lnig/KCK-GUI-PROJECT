package com.example.kckgui;

import com.example.kckgui.Model.Class.Product;
import com.example.kckgui.Model.Class.Shopping;
import com.example.kckgui.Model.Class.Task;
import com.example.kckgui.Model.Class.familyMember;
import com.example.kckgui.Model.Type.measureType;
import com.example.kckgui.Model.Type.priorityType;
import com.example.kckgui.Model.Type.statusType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    private static ArrayList<Product> products = new ArrayList<>();

    public static ArrayList<Product> getList(){
        return products;
    }

    public static void addProduct(Product product){
        products.add(product);
    }

    private static ArrayList<Task> tasks = new ArrayList<>();

    public static ArrayList<Task> getTasks(){
        return tasks;
    }
    public static void addTask(Task task){
        tasks.add(task);
    }

    private static ArrayList<Shopping> shoppings = new ArrayList<>();
    public static ArrayList<Shopping> getShoppings(){
        return shoppings;
    }
    public static void addShopping(Shopping shopping){
        shoppings.add(shopping);
    }

    private static ArrayList<familyMember> members = new ArrayList<>();
    public static ArrayList<familyMember> getMembers(){
        return members;
    }
    public static void addMember(familyMember member){
        members.add(member);
    }

    public List<Task> DataTasks(){
        List<Task> list = new ArrayList<>();
        Task task1 = new Task(1,"Utwórz prezentację", "Przygotuj prezentację dotyczącą nowego projektu", priorityType.WYSOKI, statusType.W_TOKU, new familyMember("Filip"));
        Task task2 = new Task(2,"Zakupy spożywcze", "Zakup potrzebnych artykułów spożywczych na ten tydzień", priorityType.NISKI, statusType.DO_ZROBIENIA, new familyMember("Mateusz"));
        Task task3 = new Task(3,"Raport miesięczny", "Przygotuj raport miesięczny z wyników działu sprzedaży", priorityType.SREDNI, statusType.WYKONANE, new familyMember("Patrycja"));
        Task task4 = new Task(4,"Przygotuj prezentację", "Utwórz prezentację dla klienta na jutrzejsze spotkanie", priorityType.WYSOKI, statusType.W_TOKU, new familyMember("Pawel"));
        Task task5 = new Task(5,"Ogród", "Zadbanie o ogród, przycięcie drzew i podlewanie kwiatów", priorityType.NISKI, statusType.DO_ZROBIENIA, new familyMember("Grzegorz"));
        Task task6 = new Task(6, "Sprzątanie domu", "Posprzątaj cały dom przed planowaną wizytą gości", priorityType.SREDNI, statusType.WYKONANE, new familyMember("Maciek"));
        Task task7 = new Task(7, "Rozwój umiejętności", "Zapisz się na kurs programowania w języku Java", priorityType.WYSOKI, statusType.W_TOKU, new familyMember("Ola"));
        Task task8 = new Task(8, "Wakacyjny wyjazd", "Zaplanuj wakacyjny wyjazd i zarezerwuj miejsca noclegowe", priorityType.NISKI, statusType.DO_ZROBIENIA, new familyMember("Sylwia"));
        Task task9 = new Task(9,"Zorganizuj urodziny", "Zaplanuj przyjęcie urodzinowe dla przyjaciela", priorityType.SREDNI, statusType.WYKONANE, new familyMember("Klaudia"));
        Task task10 = new Task(10,"Projekt aplikacji", "Rozpocznij pracę nad nowym projektem aplikacji mobilnej", priorityType.PILNE, statusType.W_TOKU, new familyMember("Piotr"));
        Task task11 = new Task(11,"Zorganizuj urodziny", "Zaplanuj przyjęcie urodzinowe dla przyjaciela", priorityType.SREDNI, statusType.WYKONANE, new familyMember("Klaudia"));
        Task task12 = new Task(12,"Zorganizuj urodziny1", "Zaplanuj przyjęcie urodzinowe dla przyjaciela", priorityType.SREDNI, statusType.WYKONANE, new familyMember("Klaudia"));
        Task task13 = new Task(13,"Zorganizuj urodziny2", "Zaplanuj przyjęcie urodzinowe dla przyjaciela", priorityType.SREDNI, statusType.WYKONANE, new familyMember("Klaudia"));
        Task task14 = new Task(14,"Zorganizuj urodziny3", "Zaplanuj przyjęcie urodzinowe dla przyjaciela", priorityType.PILNE, statusType.WYKONANE, new familyMember("Klaudia"));

        list.add(task1);
        list.add(task2);
        list.add(task3);
        list.add(task4);
        list.add(task5);
        list.add(task6);
        list.add(task7);
        list.add(task8);
        list.add(task9);
        list.add(task10);
        list.add(task11);
        list.add(task12);
        list.add(task13);
        list.add(task14);

        return list;
    }
    public List<Product> DataProduct(){

        List<Product> list = new ArrayList<>();

        list.add(new Product("Chleb", "Zywnosc", 2.1, measureType.SZT));
        list.add(new Product("Mleko", "Nabial", 3.5, measureType.SZT));
        list.add(new Product("Jogurt", "Nabial", 2.0, measureType.SZT));
        list.add(new Product("Jajka", "Nabial", 5.99, measureType.SZT));
        list.add(new Product("Ryż", "Produkty zbożowe", 7.5, measureType.KG));
        list.add(new Product("Marchewka", "Warzywa", 1.8, measureType.KG));
        list.add(new Product("Pomarańcze", "Owoce", 4.99, measureType.KG));
        list.add(new Product("Woda mineralna", "Napoje", 2.49, measureType.SZT));
        list.add(new Product("Szynka", "Wędlina", 15.99, measureType.KG));
        list.add(new Product("Papier toaletowy", "Artykuły gospodarstwa domowego", 3.79, measureType.SZT));

        return list;
    }
    public List<Shopping> DataShopping(){
        int i = 0;

        List<Shopping> list = new ArrayList<>();

        for (Product p: products){
            list.add(new Shopping(products.get(i++),0));
        }

        return list;
    }
    public List<familyMember> DataMembers(){

        List<familyMember> list = new ArrayList<>();

        list.add(new familyMember("Filip"));
        list.add(new familyMember("Paulina"));
        list.add(new familyMember("Grzegorz"));

        return list;
    }


    double x,y;
    @Override
    public void start(Stage primaryStage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        tasks.addAll(DataTasks());
        products.addAll(DataProduct());
        shoppings.addAll(DataShopping());
        members.addAll(DataMembers());

        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);
        });

        primaryStage.setScene(new Scene(root, 900, 556));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}