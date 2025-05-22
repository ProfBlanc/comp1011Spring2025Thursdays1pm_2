package ca.georgiancollege.comp1011spring2025thursdays1pm_2;

import java.util.ArrayList;
import java.util.Arrays;

public class CameraModel {

    /*
            Let's create 5 attributes of a Camera
            one of which is an enum

            Brands: enum
                Canon
                Sony
                Nikon
                FujiFilm

            weight
            color
            Mode: enum
                Night
                Auto
                Manual
                LowLight
                GrayScale
            resolution
     */

    private String color = "black";
    private double resolution = 1080;
    private float weight = 100;
    enum Brands {CANON, NIKON, FUJIFILM, SONY}
    private Brands brand = Brands.CANON;
    //create the remaining instance variables.
    // create getters and setters
    // for String, float, and double values
    //      add restrictions
    //create 2 constructors: default + & 5-arg constructor

    enum Modes{LOW_LIGHT, NIGHT, AUTO, MANUAL, GREYSCALE}
    private Modes mode = Modes.MANUAL;

    private double price = 100;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if(color.length() < 3){
            System.err.println("Color is too short");
            throw new IllegalArgumentException("Color must have at least 3 characters");
        }

        if(!Arrays.asList("red,blue,green,white,grey,black".split(",")).contains(color.toLowerCase())){
            throw new IllegalArgumentException("Color is not valid");
        }

        this.color = color;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if(weight < 100 || weight > 1000){
            throw new IllegalArgumentException("Weight is not valid");
        }
        this.weight = weight;
    }

    public Modes getMode() {
        return mode;
    }

    public void setMode(Modes mode) {
        this.mode = mode;
    }

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
    }

    public double getResolution() {

        return resolution;
    }

    public void setResolution(double resolution) {
        if(resolution < 1080 || resolution > 15000)
            throw new IllegalArgumentException("Resolution is not valid");

        this.resolution = resolution;
    }

    public CameraModel(String color, double resolution, float weight, Brands brand, Modes mode) {
//        this.color = color;
//        this.resolution = resolution;
//        this.weight = weight;
//        this.brand = brand;
//        this.mode = mode;
        setColor(color);
        setResolution(resolution);
        setWeight(weight);
        setBrand(brand);
        setMode(mode);
    }
    public CameraModel(){}

    public static ArrayList<String> getAllBrands(){

        ArrayList<String> brands = new ArrayList<>();
        for(Brands b : Brands.values()){

            brands.add(b.toString());
        }
        return brands;
    }
    public static ArrayList<String> getAllModes(){

        ArrayList<String> modes = new ArrayList<>();
        for(Modes m : Modes.values()){

            modes.add(m.toString());
        }
        return modes;
    }

    @Override
    public String toString() {
        return "CameraModel{" +
                "color='" + color + '\'' +
                ", resolution=" + resolution +
                ", weight=" + weight +
                ", brand=" + brand +
                ", mode=" + mode +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 100 || price > 1000){
            throw new IllegalArgumentException("Price is not valid. Must be between $100 and $1000");
        }
        this.price = price;
    }
}
