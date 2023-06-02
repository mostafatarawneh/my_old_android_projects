package com.mos.tar;

public class debt_data {

    private int id;
    private String name;
    private double amount;
    private String note;

    public debt_data(String name, double amount, String note) {
        this.name = name;
        this.amount = amount;
        this.note = note;
    }

    public debt_data(int id, String name, double amount, String note) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    //overriding the toString() method to avoid printing the address
    @Override
    public String toString() {
        return "name" + name +
                "amount" + amount +
                "notes" + note;
    }
}



