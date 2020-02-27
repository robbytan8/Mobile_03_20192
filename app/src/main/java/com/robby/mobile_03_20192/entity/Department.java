package com.robby.mobile_03_20192.entity;

import androidx.annotation.NonNull;

/**
 * @author Robby (720307)
 */
public class Department {

    private String id;
    private String name;

    public Department() {
    }

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("%s - %s", getId(), getName());
    }
}
