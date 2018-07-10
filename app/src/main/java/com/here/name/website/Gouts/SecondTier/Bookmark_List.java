package com.here.name.website.Gouts.SecondTier;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.here.name.website.Gouts.R;
import com.here.name.website.Gouts.adapter.CardAdapter;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Charles on 5/26/2018.
 */

public class Bookmark_List extends AppCompatActivity{
    public static ArrayList<Food>lstbkmrk=new ArrayList<>();
    public static String bkmkdlst="bookmarked list";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);

        loadData();
        RecyclerView myrv=(RecyclerView) findViewById(R.id.dish_list_id);
        CardAdapter theAdapter= new CardAdapter(this,lstbkmrk);
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

    private void loadData(){
        SharedPreferences mPreferences=getSharedPreferences("shared prefs",MODE_PRIVATE);
        Gson gson= new Gson();
        String json= mPreferences.getString(bkmkdlst,null);
        boolean liker=mPreferences.getBoolean("liker",false);
        Type type= new TypeToken<ArrayList<Food>>() {}.getType();
        Bookmark_List.lstbkmrk=gson.fromJson(json,type);

        if(Bookmark_List.lstbkmrk==null){
            Bookmark_List.lstbkmrk=new ArrayList<>();
        }
    }

}
