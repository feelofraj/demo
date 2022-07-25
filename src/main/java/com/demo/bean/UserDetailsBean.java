package com.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class UserDetailsBean {
    private String name;
    private int id;
    private double exp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

}
