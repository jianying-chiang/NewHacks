package com.ramenbois.newhacks.myapplication.Model;

import java.util.ArrayList;

public class Recipe {

    ArrayList<Ingredient> ingredients;
    String imageURL;
    String sourceURL;
    String f2fURL;
    String title;
    String publisher;
    String publisherURL;
    int socialRank;
    int rating;

    public Recipe(ArrayList<Ingredient> ingredients, String imageURL, String sourceURL, String f2fURL,
                  String title, String publisher, String publisherURL, int socialRank, int rating) {
        this.ingredients = ingredients;
        this.imageURL = imageURL;
        this.sourceURL = sourceURL;
        this.f2fURL = f2fURL;
        this.title = title;
        this.publisher = publisher;
        this.publisherURL = publisherURL;
        this.socialRank = socialRank;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public String getF2fURL() {
        return f2fURL;
    }

    public void setF2fURL(String f2fURL) {
        this.f2fURL = f2fURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisherURL() {
        return publisherURL;
    }

    public void setPublisherURL(String publisherURL) {
        this.publisherURL = publisherURL;
    }

    public int getSocialRank() {
        return socialRank;
    }

    public void setSocialRank(int socialRank) {
        this.socialRank = socialRank;
    }
}
