package com.here.name.website.Gouts.SecondTier;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.here.name.website.Gouts.R;
import com.here.name.website.Gouts.ThirdTier.ViewItem_Acivity;

import java.util.ArrayList;

/**
 * Created by Charles on 6/25/2018.
 */

public class MakeRec extends AppCompatActivity {

    private static final String TAG = "MakeRec";

    private EditText name;
    private EditText prepTime;
    private EditText description;
    private EditText ingreds;
    private Switch mSwitch;
    private Button mButt;
    private ArrayList ingredlst;
    private int img;
    private boolean liked=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_recipe);
        name=(EditText) findViewById(R.id.newRecipeName);
        prepTime=(EditText) findViewById(R.id.newPrepTime);
        description=(EditText) findViewById(R.id.newDescription);
        ingreds=(EditText) findViewById(R.id.newIngredients);
        mSwitch=(Switch) findViewById(R.id.switch1);
        mButt=(Button) findViewById(R.id.done);
        img=R.drawable.myfood;

        ingredlst=new ArrayList<String>();

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    liked=true;
                    Log.d(TAG, "onCheckedChanged: "+isChecked);
                }
            }
        });

        mButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add New Food
                createRecipe();
            }
        });
    }

    private void createRecipe(){
        final String nam=name.getText().toString();
        final String tim=prepTime.getText().toString();
        final String desc=description.getText().toString();
        final String s=ingreds.getText().toString();

        final Food foo=new Food(nam,tim,er(s,ingredlst),desc,img,liked);

        if(liked==true){
            Bookmark_List.lstbkmrk.add(foo);
            saveBookmark();
            My_List.monlst.add(foo);
            saveRecipe();
            Toast.makeText(MakeRec.this, "Added Your Recipe!", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MakeRec.this, My_List.class);
            startActivity(intent);
        }else{
            My_List.monlst.add(foo);
            saveRecipe();
            Toast.makeText(MakeRec.this, "Added Your Recipe!", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MakeRec.this, My_List.class);
            startActivity(intent);
        }
    }

    //todo FIX THIS
    private String er(String s,ArrayList<String> k){
        int spot=0;
        String t="";
        for(int i=0;i<s.length();i++){
            if(s.substring(i,i+1).equals(",")){
                t=s.substring(spot,i+1);
                k.add(t+"\n\n");
                if(s.charAt(i+1)==' '){
                    spot=i+2;
                }else{
                    spot=i+1;
                }

            }
        }

        String b="";
        for(int i=0;i<k.size();i++){
            b+=k.get(i);
        }
        return b;
    }

    public void saveRecipe(){
        SharedPreferences mPreferences=getSharedPreferences("recipe",MODE_PRIVATE);
        SharedPreferences.Editor mEditor=mPreferences.edit();
        Gson gson= new Gson();
        String json=gson.toJson(My_List.monlst);
        mEditor.putString(My_List.mList,json);
        mEditor.apply();
    }
    public void saveBookmark(){
        SharedPreferences mPreferences=getSharedPreferences("shared prefs",MODE_PRIVATE);
        SharedPreferences.Editor mEditor=mPreferences.edit();
        Gson gson= new Gson();
        String json=gson.toJson(Bookmark_List.lstbkmrk);
        mEditor.putBoolean("liker",liked);
        mEditor.putString(Bookmark_List.bkmkdlst,json);
        mEditor.apply();
    }
}
