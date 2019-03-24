package com.ramenbois.newhacks.myapplication.Model;

import java.util.ArrayList;

public class User {
    String userId;
    ArrayList<Ingredient> produce;
    ArrayList<Recipe> pastRecipes;


    public User(String userId, ArrayList<Ingredient> produce, ArrayList<Recipe> pastRecipes) {
        this.userId = userId;
        this.produce = produce;
        this.pastRecipes = pastRecipes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<Ingredient> getProduce() {
        return produce;
    }

    public void setProduce(ArrayList<Ingredient> produce) {
        this.produce = produce;
    }

    public ArrayList<Recipe> getPastRecipes() {
        return pastRecipes;
    }

    public void setPastRecipes(ArrayList<Recipe> pastRecipes) {
        this.pastRecipes = pastRecipes;
    }
}
