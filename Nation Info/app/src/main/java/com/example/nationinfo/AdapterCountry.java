package com.example.nationinfo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCountry extends RecyclerView.Adapter<AdapterCountry.ViewHolder>{

    private List<Country> ListCountry;
    private Context context;

    public AdapterCountry(List<Country> listCountry, Context context) {
        this.ListCountry = listCountry;
        this.context = context;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.country_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Country country = ListCountry.get(position);
            holder.Logo.setImageBitmap(country.getLogobitmap());
            holder.countryname.setText(country.getCountryName());
        Log.d("CCC",country.getPopulation());
            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailCountry.class);
                    intent.putExtra("data",country);
                    context.startActivity(intent);

                }
            });
    }


    @Override
    public int getItemCount() {
        return ListCountry == null? 0 : ListCountry.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView Logo;
        TextView countryname;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Logo = (ImageView) itemView.findViewById(R.id.logo);
            countryname = (TextView) itemView.findViewById(R.id.tvcountryname);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relative);
        }
    }
}
