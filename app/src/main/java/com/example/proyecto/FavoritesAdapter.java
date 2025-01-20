package com.example.proyecto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder> {


    private List<String> favoritesList = new ArrayList<>();




    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemfavorite, parent, false);
        return new FavoritesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {

        String favoriteItem = favoritesList.get(position);
        holder.textView.setText(favoriteItem);
    }

    @Override
    public int getItemCount() {

        return favoritesList.size();
    }


    public static class FavoritesViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public FavoritesViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textfavorites);
        }
    }

    public void setFavoritesList(List<String> favoritesList) {
        this.favoritesList = favoritesList;
        notifyDataSetChanged();
    }
}
