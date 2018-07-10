package com.here.name.website.Gouts.ThirdTier;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.here.name.website.Gouts.R;
import com.here.name.website.Gouts.SecondTier.Bookmark_List;
import com.here.name.website.Gouts.SecondTier.Dish_List;
import com.here.name.website.Gouts.SecondTier.Food;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ViewItem_Acivity extends AppCompatActivity {
    public static final String TAG = "Dumb";
    private TextView tvName,tvDesc,tvTime,tvIngr;
    private ImageView img;
    private boolean liked=false;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        tvName= (TextView) findViewById(R.id.dishNameHere);
        tvIngr= (TextView) findViewById(R.id.dishIngredientsHere);
        tvTime= (TextView) findViewById(R.id.dishTimeHere);
        tvDesc= (TextView) findViewById(R.id.dishDescHere);
        img= (ImageView) findViewById(R.id.dishThumbnailHere);

        loadLiked();

        if(liked==false){
            fab=(FloatingActionButton) findViewById(R.id.plus);
        }else{
            fab=(FloatingActionButton) findViewById(R.id.minus);
        }

        //Receive data
        Intent intent=getIntent();
        final String name=intent.getExtras().getString("Name");
        final String time=intent.getExtras().getString("Time");
        final String ingr=intent.getExtras().getString("Ingr");
        final String desc=intent.getExtras().getString("Desc");
        final int image= intent.getExtras().getInt("Thumbnail");
        final Food f=new Food(name,time,ingr,desc,image,liked);

        //Setting values
        tvName.setText(name);
        tvIngr.setText(ingr);
        tvDesc.setText(desc);
        tvTime.setText(time);
        img.setImageResource(image);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(liked==false){
                        liked=true;
                        Bookmark_List.lstbkmrk.add(f);
                        saveData();
                        saveLiked();
                        Toast.makeText(ViewItem_Acivity.this, "Added to Bookmarks", Toast.LENGTH_SHORT).show();
                        fab.setImageResource(R.drawable.minus);
                    }else{
                        liked=false;
                        Bookmark_List.lstbkmrk.remove(f);
                        saveData();
                        saveLiked();
                        Toast.makeText(ViewItem_Acivity.this, "Removed from Bookmarks", Toast.LENGTH_SHORT).show();
                        fab.setImageResource(R.drawable.plus);
                }
            }
        });
    }

    public void saveLiked(){
        SharedPreferences mPreferences=getSharedPreferences("loo",MODE_PRIVATE);
        SharedPreferences.Editor mEditor=mPreferences.edit();
        mEditor.putBoolean("liker",liked);
        mEditor.apply();
    }
    public void saveData(){
        SharedPreferences mPreferences=getSharedPreferences("shared prefs",MODE_PRIVATE);
        SharedPreferences.Editor mEditor=mPreferences.edit();
        Gson gson= new Gson();
        String json=gson.toJson(Bookmark_List.lstbkmrk);
        mEditor.putBoolean("liker",liked);
        mEditor.putString(Bookmark_List.bkmkdlst,json);
        mEditor.apply();
    }
    private void loadLiked(){
        SharedPreferences mPreferences=getSharedPreferences("loo",MODE_PRIVATE);
        boolean liker=mPreferences.getBoolean("liker",false);
    }
}