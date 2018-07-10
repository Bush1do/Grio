package com.here.name.website.Gouts.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.here.name.website.Gouts.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Someone else on 6/27/2017.
 */

public class TextAdapter extends RecyclerView.Adapter {
    private List<String> mItems=new ArrayList<>();
    public boolean liked=false;

    public void setmItems(List<String> items){
        mItems=items;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0) {
            return TextViewHolder.inflate(parent);
        }else{
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof TextViewHolder){
            ((TextViewHolder) holder).bind(mItems.get(position));

        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    static class TextViewHolder extends RecyclerView.ViewHolder{
        private TextView mtextView;
        public static TextViewHolder inflate(ViewGroup parent){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
            return new TextViewHolder(view);
        }

        public TextViewHolder(View itemView) {
            super(itemView);
            mtextView= (TextView) itemView.findViewById(R.id.list_item_text);
        }
        public void bind(String text){
            mtextView.setText(text);
        }
    }
}
