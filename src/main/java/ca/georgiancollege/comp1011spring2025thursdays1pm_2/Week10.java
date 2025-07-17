package ca.georgiancollege.comp1011spring2025thursdays1pm_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.Modifier;

public class Week10 {

    public static void main(String[] args) {

        Person p = new Person();
        p.name = "Ben";
        p.nickname = "ProfBlanc";
        p.height = 150;
        p.weight = 80;


//        String json = new Gson().toJson(p);
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.PRIVATE, Modifier.PROTECTED)
                //.excludeFieldsWithoutExposeAnnotation()
                .create();

        String json = gson.toJson(p);


        System.out.println(json);


        Person p1 = gson.fromJson(json, Person.class);
        System.out.println(gson.toJson(p1));


    }
}
