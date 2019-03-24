package com.ramenbois.newhacks.myapplication.Model;

import java.util.Date;

class Ingredient {
    String name;
    Date expiry;

    public Ingredient(String name, Date expiry) {
        this.name = name;
        this.expiry = expiry;
    }

    public String getName() {
        return name;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }
}
