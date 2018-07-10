package com.here.name.website.Gouts.ThirdTier;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.here.name.website.Gouts.R;
import com.here.name.website.Gouts.SecondTier.Bookmark_List;
import com.here.name.website.Gouts.SecondTier.Food;
import com.here.name.website.Gouts.adapter.CardAdapter;

public class ViewItem_Acivity_Bookie extends AppCompatActivity {
    public static final String TAG = "Dumb";
    private TextView tvName,tvDesc,tvTime,tvIngr;
    private ImageView img;
    private FloatingActionButton fab;
    private boolean liked=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item_bookie);

        tvName= (TextView) findViewById(R.id.dishNameHere);
        tvIngr= (TextView) findViewById(R.id.dishIngredientsHere);
        tvTime= (TextView) findViewById(R.id.dishTimeHere);
        tvDesc= (TextView) findViewById(R.id.dishDescHere);
        img= (ImageView) findViewById(R.id.dishThumbnailHere);
        fab=(FloatingActionButton) findViewById(R.id.minus);

        //Receive data
        Intent intent=getIntent();
        final String name=intent.getExtras().getString("Name");
        final String time=intent.getExtras().getString("Time");
        final String ingr=intent.getExtras().getString("Ingr");
        final String desc=intent.getExtras().getString("Desc");
        final int image= intent.getExtras().getInt("Thumbnail");
        final boolean isitliked= intent.getExtras().getBoolean("Isitliked");
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
                Log.d(TAG, "onClick: "+this+" when");
                for(int i=0;i<Bookmark_List.lstbkmrk.size();i++){
                    if(Bookmark_List.lstbkmrk.get(i).getName().equals(f.getName())){
                        Bookmark_List.lstbkmrk.remove(i);
                        saveData();
                    }
                }
                Toast.makeText(ViewItem_Acivity_Bookie.this, "Removed from Bookmarks", Toast.LENGTH_SHORT).show();
            }
        });
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
}