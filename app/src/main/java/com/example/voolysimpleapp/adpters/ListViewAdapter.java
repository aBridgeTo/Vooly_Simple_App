package com.example.voolysimpleapp.adpters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.voolysimpleapp.R;
import com.example.voolysimpleapp.javaClass.DownloadImageTask;
import com.example.voolysimpleapp.modelClasses.Hero;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Hero> {

    //the hero list that will be displayed
    private List<Hero> heroList;

    //the context object
    private Context mCtx;



    public ListViewAdapter(@NonNull Context context, List<Hero> heroList) {
        super(context, R.layout.list_items, heroList);

        this.heroList = heroList;
        this.mCtx = context;

    }

    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.list_items, null, true);

        //getting text views
        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewImageUrl = listViewItem.findViewById(R.id.textViewImageUrl);
        ImageView imageView = listViewItem.findViewById(R.id.image_view);


        //Getting the hero for the specified position
        Hero hero = heroList.get(position);

        //setting hero values to textviews
        textViewName.setText(hero.getName());
        textViewImageUrl.setText(hero.getImageUrl());

        //set image in image view form URl

        new DownloadImageTask(imageView).execute(hero.getImageUrl());


        //returning the listitem
        return listViewItem;
    }
}
