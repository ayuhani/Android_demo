package com.ayuhani.demo.design;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ayuhani.demo.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by wang on 2018/5/22.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private Context mContext;
    private List<Fruit> mFruitList;

    public FruitAdapter(List<Fruit> mFruitList) {
        this.mFruitList = mFruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_fruit, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Intent it = new Intent(mContext, FruitActivity.class);
                it.putExtra(FruitActivity.FRUIT_NAME, fruit.getName());
                it.putExtra(FruitActivity.FRUIT_IMAGE_URL, fruit.getImageUrl());
                mContext.startActivity(it);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.tvName.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageUrl()).into(holder.ivFruit);
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView ivFruit;
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            ivFruit = itemView.findViewById(R.id.iv_fruit);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
