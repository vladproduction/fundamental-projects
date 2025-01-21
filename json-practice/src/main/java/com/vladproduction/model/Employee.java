package com.vladproduction.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Employee is the java bean representing the root json object.
 * */
public class Employee {

    private int id;
    private String name;
    private boolean permanent;
    private Address address;
    private long[] phoneNumbers;
    private String role;
    private List<String> cities;
    private Map<String, String> properties;

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
    public boolean isPermanent() {
        return permanent;
    }
    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public long[] getPhoneNumbers() {
        return phoneNumbers;
    }
    public void setPhoneNumbers(long[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("***** Employee Details *****\n");
        sb.append("ID=").append(getId()).append("\n");
        sb.append("Name=").append(getName()).append("\n");
        sb.append("Permanent=").append(isPermanent()).append("\n");
        sb.append("Role=").append(getRole()).append("\n");
        sb.append("Phone Numbers=").append(Arrays.toString(getPhoneNumbers())).append("\n");
        sb.append("Address=").append(getAddress()).append("\n");
        sb.append("Cities=").append(Arrays.toString(getCities().toArray())).append("\n");
        sb.append("Properties=").append(getProperties()).append("\n");
        sb.append("*****************************\n");

        return sb.toString();
    }
    public List<String> getCities() {
        return cities;
    }
    public void setCities(List<String> cities) {
        this.cities = cities;
    }
    public Map<String, String> getProperties() {
        return properties;
    }
    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

}
