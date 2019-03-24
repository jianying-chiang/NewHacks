package com.ramenbois.newhacks.myapplication;

import com.ramenbois.newhacks.myapplication.Model.Recipe;

import java.util.ArrayList;

public class Data {
    ArrayList<String> r1_rec = new ArrayList<>();
    String r1_in = "2 Tbsp olive oil\n" +
            "1 large onion, chopped\n" +
            "1 large garlic clove, minced\n" +
            "3 quarts of chicken stock or beef stock OR water OR a mixture of both (we usually use half stock half water as the meatballs will create their own stock)*\n" +
            "1/2 cup of tomato sauce\n" +
            "1/2 lb of string beans, strings and ends removed, cut into 1 inch pieces\n" +
            "2 large carrots, peeled and sliced\n" +
            "1/3 cup of raw white rice\n" +
            "1 pound ground beef\n" +
            "1/4 cup of chopped fresh mint leaves\n" +
            "1/4 cup of chopped parsley\n" +
            "1 raw egg\n" +
            "1 1/2 teaspoon salt\n" +
            "1/4 teaspoon black pepper\n" +
            "A dash of cayenne (optional)\n" +
            "1 1/2 cup of frozen or fresh peas\n" +
            "1 teaspoon of dried oregano, crumbled, or 1 Tbsp fresh chopped oregano\n" +
            "Salt and pepper\n" +
            "1/2 cup chopped fresh cilantro";
    ArrayList<String> r2_rec = new ArrayList<>();
    String r2_in = "200g short-grain or sushi rice , rinsed\n" +
            "100g panko breadcrumbs\n" +
            "1 tsp turmeric\n" +
            "1 tbsp vegetable oil\n" +
            "1 egg white\n" +
            "450g pork fillets , trimmed and cut into 8 pieces\n" +
            "coriander sprigs, to garnish (optional)\n" +
            "pickled ginger , to serve (optional)\n" +
            "1 tbsp vegetable oil\n" +
            "1 onion , chopped\n" +
            "1 medium carrot , grated\n" +
            "2 eating apples , such as Braeburn, peeled, cored and roughly chopped\n" +
            "2 fat garlic cloves , sliced\n" +
            "2 tsp medium curry powder\n" +
            "tsp ground ginger\n" +
            "1 tbsp tomato pure\n" +
            "2 tsp clear honey\n" +
            "1 tbsp soy sauce\n" +
            "1 tbsp cornflour\n" +
            "350ml chicken stock\n" +
            "1 tsp sesame oil";
    ArrayList<String> r3_rec = new ArrayList<>();
    String r3_in = "1 tablespoon vegetable oil\n" +
            "1 onion, chopped\n" +
            "1 pound smoked sausage, sliced\n" +
            "3 cups water\n" +
            "1 head cabbage, cored and coarsely chopped\n" +
            "3 carrots, sliced\n" +
            "3 stalks celery, sliced\n" +
            "1/3 cup uncooked long grain white rice\n" +
            "1 (15 ounce) can red beans, with liquid\n" +
            "1 (8 ounce) can tomato sauce\n" +
            "1 (28 ounce) can crushed tomatoes\n" +
            "2 cubes chicken bouillon\n" +
            "salt to taste\n" +
            "1 bay leaf\n" +
            "1/2 teaspoon crushed dried thyme";
    ArrayList<String> r4_rec = new ArrayList<>();
    String r4_in = "1 tablespoon olive oil\n" +
            "1 large onion, sliced\n" +
            "2 (14.5 ounce) cans stewed tomatoes\n" +
            "1/2 (6 ounce) can tomato paste\n" +
            "1 teaspoon salt\n" +
            "1/4 teaspoon black pepper\n" +
            "1/4 teaspoon cayenne pepper\n" +
            "1/2 teaspoon red pepper flakes\n" +
            "1 tablespoon Worcestershire sauce\n" +
            "1 teaspoon chopped fresh rosemary\n" +
            "2 cups water\n" +
            "1 (3 pound) whole chicken, cut into 8 pieces\n" +
            "1 cup uncooked white rice\n" +
            "1 cup diced carrots\n" +
            "1/2 pound fresh green beans, trimmed and snapped into 1 to 2 inch pieces\n" +
            "1/4 teaspoon ground nutmeg";
    ArrayList<String> r5_rec = new ArrayList<>();
    String r5_in = "1/4 cup butter\n" +
            "1/4 cup sliced onion\n" +
            "1/4 cup sliced carrots\n" +
            "1/4 cup chopped celery\n" +
            "1/4 cup chopped green bell pepper\n" +
            "1 apple - peeled, cored and sliced\n" +
            "1 cup chopped chicken breast meat\n" +
            "1/4 cup all-purpose flour\n" +
            "1 teaspoon curry powder\n" +
            "1/4 teaspoon chopped fresh mace\n" +
            "4 whole cloves\n" +
            "1 tablespoon chopped fresh parsley\n" +
            "1 cup stewed tomatoes\n" +
            "salt and pepper to taste\n" +
            "1 cup cooked white rice\n" +
            "5 cups beef stock";

    Recipe r1;
    Recipe r2;
    Recipe r3;
    Recipe r4;

    public Recipe getR4() {
        return r4;
    }

    public void setR4(Recipe r4) {
        this.r4 = r4;
    }

    public Recipe getR5() {
        return r5;
    }

    public void setR5(Recipe r5) {
        this.r5 = r5;
    }

    Recipe r5;

    public Data() {
        r1_rec.add(r1_in);
        r1 = new Recipe(r1_rec,
                "http://static.food2fork.com/albondigassoup300x200d72a293c.jpg",
                "https://www.simplyrecipes.com/recipes/albondigas_soup/",
                "https://www.food2fork.com/view/Albondigas_Soup/35689",
                "Albondigas Soup",
                "Simply Recipes",
                "https://www.simplyrecipes.com",
                0,
                (float) 100.0);

        r2_rec.add(r2_in);
        r2 = new Recipe(r2_rec,
                "http://static.food2fork.com/2875679_MEDIUM6092.jpg",
                "http://www.bbcgoodfood.com/recipes/2875679/katsu-pork-with-sticky-rice",
                "https://www.food2fork.com/view/Katsu_pork_with_sticky_rice/37cbda",
                "Katsu pork w/ sticky rice",
                "Simply Recipes",
                "http://www.bbcgoodfood.com/",
                0,
                (float) 80.9);

        r3_rec.add(r3_in);
        r3 = new Recipe(r3_rec,
                "http://static.food2fork.com/9734581dc1.jpg",
                "https://www.allrecipes.com/recipe/77836/cabbage-and-smoked-sausage-soup/",
                "https://www.food2fork.com/view/Cabbage_and_Smoked_Sausage_Soup/5362",
                "Cabbage & Smoked Sausage Soup",
                "All Recipes",
                "https://www.allrecipes.com/",
                0,
                (float) 40.7);
        r4_rec.add(r4_in);
        r4 = new Recipe(r4_rec,
                "http://static.food2fork.com/355930609.jpg",
                "https://www.allrecipes.com/recipe/67061/jollof-rice/",
                "https://www.food2fork.com/view/Jollof_Rice/18025",
                "Jollof Rice",
                "All Recipes",
                "https://www.allrecipes.com/",
                0,
                (float) 37.95);
        r5_rec.add(r5_in);
        r5 = new Recipe(r5_rec,
                "http://static.food2fork.com/95853324e8.jpg",
                "https://www.allrecipes.com/recipe/13259/mulligatawny-soup-iii/",
                "https://www.food2fork.com/view/Mulligatawny_Soup_III/e89c77",
                "Mulligatawny Soup III",
                "All Recipes",
                "https://www.allrecipes.com/",
                0,
                (float) 37.45);
    }

    public ArrayList<String> getR1_rec() {
        return r1_rec;
    }

    public void setR1_rec(ArrayList<String> r1_rec) {
        this.r1_rec = r1_rec;
    }

    public Recipe getR1() {
        return r1;
    }

    public void setR1(Recipe r1) {
        this.r1 = r1;
    }

    public Recipe getR2() {
        return r2;
    }

    public void setR2(Recipe r2) {
        this.r2 = r2;
    }

    public Recipe getR3() {
        return r3;
    }

    public void setR3(Recipe r3) {
        this.r3 = r3;
    }
}
