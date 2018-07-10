package com.here.name.website.Gouts.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.here.name.website.Gouts.R;
import com.here.name.website.Gouts.SecondTier.Bookmark_List;
import com.here.name.website.Gouts.SecondTier.Dessert_List;
import com.here.name.website.Gouts.SecondTier.Dish_List;
import com.here.name.website.Gouts.SecondTier.Drink_List;
import com.here.name.website.Gouts.SecondTier.My_List;
import com.here.name.website.Gouts.SecondTier.Side_List;

import java.util.ArrayList;

/**
 * Created by Charles on 3/2/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageNames=new ArrayList<>();
    private ArrayList<Integer> mImages=new ArrayList<>();
    private Context mContext;
    public static int place=0;

    public RecyclerViewAdapter(ArrayList<String> mImageNames, ArrayList<Integer> mImages, Context mContext) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.image.setImageResource(mImages.get(position));

        holder.name.setText(mImageNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked on: "+mImageNames.get(position));
//                Toast Activity Names
//                Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();

                if(position==0){
                    //MOVE TO NEW ACTIVITY
                    Intent intent=new Intent(mContext, Bookmark_List.class);
                    place=0;
                    mContext.startActivity(intent);
                }
                if(position==1){
                    //MOVE TO NEW ACTIVITY
                    Intent intent=new Intent(mContext, My_List.class);
                    place=1;
                    mContext.startActivity(intent);
                }
                if(position==2){
                    //MOVE TO NEW ACTIVITY
                    Intent intent=new Intent(mContext, Drink_List.class);
                    place=2;
                    mContext.startActivity(intent);
                }
                if(position==3){
                    //MOVE TO NEW ACTIVITY
                    Intent intent=new Intent(mContext, Dish_List.class);
                    place=3;
                    mContext.startActivity(intent);
                }
                if(position==4){
                    //MOVE TO NEW ACTIVITY
                    Intent intent=new Intent(mContext, Side_List.class);
                    place=4;
                    mContext.startActivity(intent);
                }
                if(position==5){
                    //MOVE TO NEW ACTIVITY
                    Intent intent=new Intent(mContext, Dessert_List.class);
                    place=5;
                    mContext.startActivity(intent);
                }
            }
        });

        if(position==0){
            holder.parentLayout.setBackgroundColor(Color.parseColor("#63474d"));
        }

         if(position==1){
           holder.parentLayout.setBackgroundColor(Color.parseColor("#ede59e"));
         }

        if(position==2){
            holder.parentLayout.setBackgroundColor(Color.parseColor("#ffd166"));
        }

        if(position==3){
            holder.parentLayout.setBackgroundColor(Color.parseColor("#91f5ad"));
        }

        if(position==4){
            holder.parentLayout.setBackgroundColor(Color.parseColor("#ef767a"));
        }

        if(position==5){
            holder.parentLayout.setBackgroundColor(Color.parseColor("#ee4b6a"));
        }

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        RelativeLayout parentLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            image= (ImageView) itemView.findViewById(R.id.list_item_icon);
            name= (TextView) itemView.findViewById(R.id.list_item_text);
            parentLayout=(RelativeLayout) itemView.findViewById(R.id.parent_layout);
        }
    }

}
