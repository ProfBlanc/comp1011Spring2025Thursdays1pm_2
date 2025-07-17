package com.example.demo5;

public class Player {
    public int id;
    public String first_name;
    public String last_name;
    public String position;

    public String getFirst_name() {
        return first_name;
    }

    public int getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPosition() {
        return position;
    }

    public String getFull_name(){
        return first_name + " " + last_name;
    }

}
