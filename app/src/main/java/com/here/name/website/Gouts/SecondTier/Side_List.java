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

public class Side_List extends AppCompatActivity{

    ArrayList<Food>lstSide;
    ArrayList<String>newIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);

        lstSide=new ArrayList<>();
        //griot
        newIngredients=new ArrayList<>();
        newIngredients.add("•  2 Cups of Dried Black Mushrooms (djon djon)\n\n");
        newIngredients.add("•  3 garlic cloves minced\n\n");
        newIngredients.add("•  1 small onion chopped\n\n");
        newIngredients.add("•  2 cups long-grain rice\n\n");
        newIngredients.add("•  2 teaspoons salt\n\n");
        newIngredients.add("•  1 tsp Ground cloves\n\n");
        newIngredients.add("•  1 (12-ounce) can lima beans (or green peas)\n\n");
        newIngredients.add("•  1 to 2 thyme sprigs\n\n");
        newIngredients.add("•  1 green Scotch bonnet pepper\n\n");
        Dish griot=new Dish("Griot","30 mins",er(newIngredients),"Lorem Ipsum",R.drawable.djondjon,false);

        lstSide.add(griot);

        RecyclerView myrv=(RecyclerView) findViewById(R.id.dish_list_id);
        CardAdapter theAdapter= new CardAdapter(this,lstSide);
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
