package com.here.name.website.Gouts.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.here.name.website.Gouts.R;
import com.here.name.website.Gouts.SecondTier.Bookmark_List;
import com.here.name.website.Gouts.SecondTier.Food;
import com.here.name.website.Gouts.ThirdTier.ViewItem_Acivity;
import com.here.name.website.Gouts.ThirdTier.ViewItem_Acivity_Bookie;

import java.util.List;

import static com.here.name.website.Gouts.ThirdTier.ViewItem_Acivity.TAG;
import static com.here.name.website.Gouts.adapter.RecyclerViewAdapter.place;

/**
 * Created by Charles on 5/26/2018.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {

    private Context mContext;
    private List<Food> mData;

    public CardAdapter(Context mContext, List<Food> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater= LayoutInflater.from(mContext);
        view=mInflater.inflate(R.layout.cardview_item_food,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tv_food_name.setText(mData.get(position).getName());
        holder.img_food_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(place==0){
                    Intent intent=new Intent(mContext, ViewItem_Acivity_Bookie.class);

                    Log.d(TAG, "onClick: "+this+" cookie "+mContext);

                    intent.putExtra("Name",mData.get(position).getName());
                    intent.putExtra("Time",mData.get(position).getPrepTime());
                    intent.putExtra("Ingr",mData.get(position).getIngredients());
                    intent.putExtra("Desc",mData.get(position).getDescription());
                    intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                    intent.putExtra("Isitliked",mData.get(position).isLiked());
                    mContext.startActivity(intent);
                }else{
                    Intent intent=new Intent(mContext, ViewItem_Acivity.class);

                    intent.putExtra("Name",mData.get(position).getName());
                    intent.putExtra("Time",mData.get(position).getPrepTime());
                    intent.putExtra("Ingr",mData.get(position).getIngredients());
                    intent.putExtra("Desc",mData.get(position).getDescription());
                    intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                    intent.putExtra("Isitliked",mData.get(position).isLiked());
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_food_name;
        ImageView img_food_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_food_name= (TextView) itemView.findViewById(R.id.food_name_id);
            img_food_thumbnail=(ImageView) itemView.findViewById(R.id.food_img_id);
            cardView= (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }

}
