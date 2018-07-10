package com.here.name.website.Gouts.Home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.here.name.website.Gouts.R;
import com.here.name.website.Gouts.SecondTier.Dish_List;
import com.here.name.website.Gouts.SecondTier.MakeRec;
import com.here.name.website.Gouts.ThirdTier.ViewItem_Acivity_Bookie;
import com.here.name.website.Gouts.adapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private ArrayList<Integer> images=new ArrayList<>();
    private ArrayList<String> names=new ArrayList<>();
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab= (FloatingActionButton) findViewById(R.id.newFood);

        PopulateImages();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MakeRec.class);
                startActivity(intent);
            }
        });
    }

    private void PopulateImages(){
        images.add(R.drawable.bookmark);
        names.add("Bookmarks");

        images.add(R.drawable.large_circle);
        names.add("My Recipes");

        images.add(R.drawable.drinks);
        names.add("Drinks");

        images.add(R.drawable.ic_main);
        names.add("Dishes");

        images.add(R.drawable.sides);
        names.add("Sides");

        images.add(R.drawable.desserts);
        names.add("Desserts");

        InitRecyclerView();
    }

    private void InitRecyclerView(){
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.primaryRecycler);
        RecyclerViewAdapter adapter= new RecyclerViewAdapter(names,images,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
