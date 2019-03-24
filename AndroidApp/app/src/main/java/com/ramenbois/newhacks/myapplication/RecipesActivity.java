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
import com.ramenbois.newhacks.myapplication.Model.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class RecipesActivity extends AppCompatActivity {

    private final String jsonURL = "http://uoft-courseapi.herokuapp.com/"; // TODO: get url for json data stuff
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private RecyclerView recView;
    private List<Recipe> recipes ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        recipes = new ArrayList<>() ;
        recView = findViewById(R.id.recyclerviewid);
        Data d = new Data();
        recipes.add(d.getR1());
        recipes.add(d.getR2());
        recipes.add(d.getR3());
        recipes.add(d.getR4());
        recipes.add(d.getR5());

//        jsonRequest();
        setUpRecyclerView(recipes);
        System.out.println("AAAAAAAA I finish the JSON Request");
    }

    private void jsonRequest() {
        request = new JsonArrayRequest(jsonURL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObj;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObj = response.getJSONObject(i);
                        System.out.println(jsonObj);
                        JSONArray jsonArray = jsonObj.getJSONArray("ingredients");
                        ArrayList<String> ingredients = new ArrayList<>();
                        for (int j = 0; j < jsonArray.length(); j++) {
                            String str = new Gson().toJson(jsonArray.getJSONObject(j));
                            ingredients.add(str); // TODO: FIX THIS
                        }
                        String imageURL = jsonObj.getString("image_url");
                        String sourceURL = jsonObj.getString("source_url");
                        String f2fURL = jsonObj.getString("f2f_url");
                        String title = jsonObj.getString("title");
                        String publisher = jsonObj.getString("publisher");
                        String publisherURL = jsonObj.getString("publisher_url");
                        int socialRank = jsonObj.getInt("rating");
                        float rating = BigDecimal.valueOf(jsonObj.getDouble("social_rank")).floatValue();
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
        RecyclerViewAdapter recViewAdapter = new RecyclerViewAdapter(this);
        recViewAdapter.setmRecipes(recipes);
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(recViewAdapter);
    }

}
