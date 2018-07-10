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

public class Drink_List extends AppCompatActivity{

    ArrayList<Food>lstDrink;
    ArrayList<String>newIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);

        lstDrink=new ArrayList<>();
        //Papaya
        newIngredients=new ArrayList<>();
        newIngredients.add("•  0 Cups of Dried Black Mushrooms (djon djon)\n\n");
        newIngredients.add("•  3 garlic cloves minced\n\n");
        newIngredients.add("•  1 small onion chopped\n\n");
        newIngredients.add("•  2 cups long-grain rice\n\n");
        newIngredients.add("•  2 teaspoons salt\n\n");
        newIngredients.add("•  1 tsp Ground cloves\n\n");
        newIngredients.add("•  1 (12-ounce) can lima beans (or green peas)\n\n");
        newIngredients.add("•  1 to 2 thyme sprigs\n\n");
        newIngredients.add("•  1 green Scotch bonnet pepper\n\n");
        Dish papaya=new Dish("Papaya Juice","30 mins",er(newIngredients),",",R.drawable.legumer,false);

        lstDrink.add(papaya);

        RecyclerView myrv=(RecyclerView) findViewById(R.id.dish_list_id);
        CardAdapter theAdapter= new CardAdapter(this,lstDrink);
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
