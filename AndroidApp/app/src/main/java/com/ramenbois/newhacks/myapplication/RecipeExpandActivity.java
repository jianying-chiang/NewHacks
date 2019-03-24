package com.ramenbois.newhacks.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RecipeExpandActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipeexpand);

        Intent i = getIntent();
        ArrayList<String> ingredients  = i.getExtras().getStringArrayList("ingredients");
        String imageURL = i.getExtras().getString("imageURL");
        String sourceURL = i.getExtras().getString("sourceURL") ;
        String f2fURL = i.getExtras().getString("f2fURL");
        String title = i.getExtras().getString("title") ;
        String publisher = i.getExtras().getString("publisher") ;
        String publisherURL = i.getExtras().getString("publisherURL") ;
        int socialRank = i.getExtras().getInt("socialRank") ;
        float rating = i.getExtras().getFloat("rating") ;



        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolbarID);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView recipeURL = findViewById(R.id.recipe_url);
        TextView recipeSource = findViewById(R.id.recipe_source) ;
        TextView recipeIngredients = findViewById(R.id.recipe_ingredients);
        TextView recipeRating  = findViewById(R.id.recipe_rating) ;
        ImageView img = findViewById(R.id.recipe_thumbnail);

        // setting values to each view

        recipeURL.setText(Html.fromHtml("<a href=\"" + sourceURL + "\">Link to recipe</a>", 0));
        recipeSource.setText(publisher);
        recipeRating.setText(String.valueOf(rating));
        String ingr = "";
        for (int j = 0; j < ingredients.size(); j ++) {
            ingr += ingredients.get(j) + "\n";
        }
        recipeIngredients.setText(ingr);

        collapsingToolbarLayout.setTitle(title);



        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_rect).error(R.drawable.loading_rect);


        // set image using Glide
        Glide.with(this).load(imageURL).apply(requestOptions).into(img);

    }


}
