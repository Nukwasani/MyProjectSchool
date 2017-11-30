package com.example.thandiwe.myprojectschool;

/**
 * Created by Thandiwe on 2017/11/17.
 */

public class Learner {

    private String name, surname, address;
    private int id;

    public Learner() {
    }

    public Learner(String name, String surname, String address, int id) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
