package com.mos.databaseexamble;

public class Car {
    private int id ;
    private String model ;
    private String color ;
    private double distanceperLiter ;
    private int img;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getDistanceperLiter() {
        return distanceperLiter;
    }

    public void setDistanceperLiter(double distanceperLiter) {
        this.distanceperLiter = distanceperLiter;
    }

    public Car(int id, String model, String color, double distanceperLiter) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.distanceperLiter = distanceperLiter;

    }

    public Car(String model, String color, double distanceperLiter) {
        this.model = model;
        this.color = color;
        this.distanceperLiter = distanceperLiter;
    }

    public Car(int id) {
        this.id = id;
    }

   /* public Car(String model, String color, double distanceperLiter, int img) {
        this.model = model;
        this.color = color;
        this.distanceperLiter = distanceperLiter;
        this.img = img;
    } */
}
