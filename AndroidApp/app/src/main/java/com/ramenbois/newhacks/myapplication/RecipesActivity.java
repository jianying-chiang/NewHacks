package com.ramenbois.newhacks.myapplication;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.ramenbois.newhacks.myapplication.Model.Ingredient;
import com.ramenbois.newhacks.myapplication.Model.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RecipesActivity extends AppCompatActivity {

    private String jsonURL; // TODO: get url for json data stuff
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private RecyclerView recView;
    private List<Recipe> recipes ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);


        recipes = new ArrayList<>() ;
        recView = findViewById(R.id.recyclerviewid);
        jsonRequest();
    }

    private void jsonRequest() {
        request = new JsonArrayRequest(jsonURL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObj = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObj = response.getJSONObject(i);

                        JSONArray jsonArray = response.getJSONArray(i);
                        ArrayList<Ingredient> ingredients = new ArrayList<>();
                        for (int j = 0; j < jsonArray.length(); j++) {
                            String str = new Gson().toJson(jsonArray.getJSONObject(j));
                            ingredients.add(new Ingredient(str)); // TODO: FIX THIS
                        }
                        String imageURL = jsonObj.getString("imageURL");
                        String sourceURL = jsonObj.getString("sourceURL");
                        String f2fURL = jsonObj.getString("f2fURL");
                        String title = jsonObj.getString("title");
                        String publisher = jsonObj.getString("publisher");
                        String publisherURL = jsonObj.getString("publisherURL");
                        int socialRank = jsonObj.getInt("socialRank");
                        float rating = BigDecimal.valueOf(jsonObj.getDouble("rating")).floatValue();
                        recipes.add(new Recipe(ingredients, imageURL, sourceURL, f2fURL,
                                title, publisher, publisherURL, socialRank, rating));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setUpRecyclerView(recipes);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(RecipesActivity.this);
        requestQueue.add(request);

    }

    private void setUpRecyclerView(List<Recipe> recipes) {
        RecyclerViewAdapter recViewAdapater = new RecyclerViewAdapter(this, recipes);
        recView.setLayoutManager(new LinearLayoutManager(this));

        recView.setAdapter(recViewAdapater);

    }

}
