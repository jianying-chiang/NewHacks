package com.ramenbois.newhacks.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ramenbois.newhacks.myapplication.Model.CheckedIngr;

import java.util.ArrayList;

public class ChooseIngrActivity extends AppCompatActivity {

    ArrayList<CheckedIngr> ingredientsCheckList;
    ListView listView;
    private CustomAdapter adapter;
    Button getRecipes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseingr);
        getRecipes = findViewById(R.id.get_recipes);
        listView = (ListView) findViewById(R.id.listView);
        setUpIngredients();
        ingredientsCheckList = new ArrayList<>();

        ingredientsCheckList.add(new CheckedIngr("Apples", false));
        ingredientsCheckList.add(new CheckedIngr("Bananas", false));
        ingredientsCheckList.add(new CheckedIngr("Broccoli", false));
        ingredientsCheckList.add(new CheckedIngr("Carrots", false));
        ingredientsCheckList.add(new CheckedIngr("Chicken", false));
        ingredientsCheckList.add(new CheckedIngr("Eggs", false));
        ingredientsCheckList.add(new CheckedIngr("Fish", false));
        ingredientsCheckList.add(new CheckedIngr("Ground Beef", false));
        ingredientsCheckList.add(new CheckedIngr("Hummus", false));
        ingredientsCheckList.add(new CheckedIngr("Oranges", false));
        ingredientsCheckList.add(new CheckedIngr("Potatoes", false));
        ingredientsCheckList.add(new CheckedIngr("Rice", false));
        ingredientsCheckList.add(new CheckedIngr("Tomatoes", false));

        adapter = new CustomAdapter(ingredientsCheckList, getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                CheckedIngr dataModel= ingredientsCheckList.get(position);
                dataModel.checked = !dataModel.checked;
                adapter.notifyDataSetChanged();


            }
        });

        addGetRecipesButton();
    }

    private void addGetRecipesButton() {
        getRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> jsonList = new ArrayList<>();
                for (int i = 0; i < ingredientsCheckList.size(); i++) {
                    if (ingredientsCheckList.get(i).checked) {
                        jsonList.add(ingredientsCheckList.get(i).name);
                    }
                }
                Intent gmIntent = new Intent(ChooseIngrActivity.this, RecipesActivity.class);
                startActivity(gmIntent);
                }
            }
        );

    }


    private void setUpIngredients() {
        // TODO: pass in all ingredients some how
        ingredientsCheckList = new ArrayList<>();
    }




}
