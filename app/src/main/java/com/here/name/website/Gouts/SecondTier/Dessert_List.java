package com.here.name.website.Gouts.SecondTier;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.here.name.website.Gouts.R;
import com.here.name.website.Gouts.adapter.CardAdapter;

import java.util.ArrayList;

/**
 * Created by Charles on 5/26/2018.
 */

public class Dessert_List extends AppCompatActivity{

    ArrayList<Food>lstDessert;
    ArrayList<String>newIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);

        lstDessert=new ArrayList<>();

        RecyclerView myrv=(RecyclerView) findViewById(R.id.dish_list_id);
        CardAdapter theAdapter= new CardAdapter(this,lstDessert);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(theAdapter);
    }

    private String er(ArrayList<String> k){
            String b="";
            for(int i=0;i<k.size()-1;i++){
                b+=k.get(i)+k.get(i+1);
            }
            return b;
    }
}
