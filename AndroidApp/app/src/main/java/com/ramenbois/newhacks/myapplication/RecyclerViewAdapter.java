package com.ramenbois.newhacks.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ramenbois.newhacks.myapplication.Model.Ingredient;
import com.ramenbois.newhacks.myapplication.Model.Recipe;
import com.ramenbois.newhacks.myapplication.R.*;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Recipe> mRecipes;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Recipe> mRecipes) {
        this.mContext = mContext;
        this.mRecipes = mRecipes;
        option = new RequestOptions().centerCrop().placeholder(drawable.loading_rect).error(drawable.loading_rect);

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(layout.recipe_item, viewGroup, false);

        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        viewHolder.viewContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, RecipesActivity.class);
                i.putExtra("ingredients",mRecipes.get(viewHolder.getAdapterPosition()).getIngredients());
                i.putExtra("imageURL",mRecipes.get(viewHolder.getAdapterPosition()).getImageURL());
                i.putExtra("sourceURL",mRecipes.get(viewHolder.getAdapterPosition()).getSourceURL());
                i.putExtra("f2fURL",mRecipes.get(viewHolder.getAdapterPosition()).getF2fURL());
                i.putExtra("title",mRecipes.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("publisher",mRecipes.get(viewHolder.getAdapterPosition()).getPublisher());
                i.putExtra("publisherURL",mRecipes.get(viewHolder.getAdapterPosition()).getPublisherURL());
                i.putExtra("socialRank",mRecipes.get(viewHolder.getAdapterPosition()).getSocialRank());
                i.putExtra("rating",mRecipes.get(viewHolder.getAdapterPosition()).getRating());
                mContext.startActivity(i);

            }
        });


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.recipeName.setText(mRecipes.get(i).getTitle());
        myViewHolder.recipeRating.setText(mRecipes.get(i).getRating());
        myViewHolder.recipeSource.setText(mRecipes.get(i).getPublisher());

        Glide.with(mContext).load(mRecipes.get(i).getImageURL()).apply(option).into(myViewHolder.imgThumbnail);


    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView recipeName;
        TextView recipeRating;
        TextView recipeSource;
        ImageView imgThumbnail;
        LinearLayout viewContainer;

        public MyViewHolder(View itemView) {
            super(itemView);

            viewContainer = itemView.findViewById(R.id.container);
            recipeName = itemView.findViewById(id.recipe_name);
            recipeRating = itemView.findViewById(R.id.rating);
            recipeSource = itemView.findViewById(R.id.source);
            imgThumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }
}
