package ca.georgiancollege.comp1011spring2025thursdays1pm_2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Person {

    @Expose
    public String name;

    private int age;

    String test;

    protected double weight;

    @Expose
    @SerializedName("screen_name")
    public String nickname;

    @Expose
    public double height;


}
