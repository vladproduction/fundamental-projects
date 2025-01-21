package com.vladproduction.model;

import java.util.Arrays;

public class Person {

    private int id;
    private String name;
    private double height;
    private boolean client;
    private Address address;

    public Person(int id, String name, double height, boolean client, Address address) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.client = client;
        this.address = address;
    }

    public Person() {
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isClient() {
        return client;
    }

    public void setClient(boolean client) {
        this.client = client;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("***** Person Details *****\n");
        sb.append("ID=").append(getId()).append("\n");
        sb.append("Name=").append(getName()).append("\n");
        sb.append("Height=").append(getHeight()).append("\n");
        sb.append("Client=").append(isClient()).append("\n");
        sb.append("Address=").append(getAddress()).append("\n");
        sb.append("*****************************\n");

        return sb.toString();
    }
}
