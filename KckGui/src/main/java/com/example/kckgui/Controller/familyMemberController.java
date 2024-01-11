package com.example.kckgui.Controller;


import com.example.kckgui.Model.Class.familyMember;

import java.util.ArrayList;
import java.util.List;

public class familyMemberController {

    private static ArrayList<familyMember> familyMembers = new ArrayList<>(DataMembers());

    public static void addFamilyMember(familyMember fM){

        familyMembers.add(fM);
    }

    public static void print(){
        for (int i = 0; i < familyMembers.size(); i++){
            System.out.println(familyMembers.get(i));
        }
    }

    public static ArrayList<familyMember> getFamilyMembers() {
        return familyMembers;
    }


    public static List<familyMember> DataMembers(){

        List<familyMember> list = new ArrayList<>();

        list.add(new familyMember("Filip"));
        list.add(new familyMember("Paulina"));
        list.add(new familyMember("Grzegorz"));

        return list;
    }


}
