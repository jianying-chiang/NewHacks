package com.ramenbois.newhacks.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RecipesActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        Intent i = getIntent();
        ArrayList<String> name  = i.getExtras().getStringArrayList("ingredients");
        String imageURL = i.getExtras().getString("imageURL");
        String sourceURL = i.getExtras().getString("sourceURL") ;
        String f2fURL = i.getExtras().getString("f2fURL");
        String title = i.getExtras().getString("title") ;
        String publisher = i.getExtras().getString("publisher") ;
        String publisherURL = i.getExtras().getString("publisherURL") ;
        float socialRank = i.getExtras().getFloat("socialRank") ;
        int rating = i.getExtras().getInt("rating") ;

        // ini views

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.aa_anime_name);
        TextView tv_studio = findViewById(R.id.aa_studio);
        TextView tv_categorie = findViewById(R.id.aa_categorie) ;
        TextView tv_description = findViewById(R.id.aa_description);
        TextView tv_rating  = findViewById(R.id.aa_rating) ;
        ImageView img = findViewById(R.id.aa_thumbnail);

        // setting values to each view

        tv_name.setText(name);
        tv_categorie.setText(category);
        tv_description.setText(description);
        tv_rating.setText(rating);
        tv_studio.setText(studio);

        collapsingToolbarLayout.setTitle(name);


        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        // set image using Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(img);

    }


}
