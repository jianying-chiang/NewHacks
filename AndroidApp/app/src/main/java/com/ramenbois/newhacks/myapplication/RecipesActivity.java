package com.ramenbois.newhacks.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.ramenbois.newhacks.myapplication.Model.Ingredient;
import com.ramenbois.newhacks.myapplication.Model.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecipesActivity extends AppCompatActivity {
    private String jsonURL;
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
        jsonRequest();
    }

    private void jsonRequest() {
//        request = new JsonArrayRequest(jsonURL, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                JSONObject jsonObj = null;
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        jsonObj = response.getJSONObject(i);
//                        JSONArray jsonArray = response.getJSONArray(i);
//                        ArrayList<Object> ingredients = new ArrayList<>();
//                        for(int j=0;j < jsonArray.length();j++){
//                            ingredients.add(jsonArray.getJSONObject(j)); // TODO: FIX THIS
//                        }
//                        String imageURL;
//                        String sourceURL;
//                        String f2fURL;
//                        String title;
//                        String publisher;
//                        String publisherURL;
//                        int socialRank;
//                        int rating;
////                        Recipe recipe = new Recipe(ingredients, imageURL, sourceURL, f2fURL,
////                                title, publisher, publisherURL, socialRank, rating);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }, );
    }
}
