package com.geeky.apis;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class DataViewHolder extends RecyclerView.ViewHolder{
    private View v;
    private TextView tv_title;
    private TextView tv_name;
    private ImageView iv_news;
    public DataViewHolder(View itemView) {
        super(itemView);
        v = itemView;
        tv_name = v.findViewById(R.id.tv_name);
        tv_title = v.findViewById(R.id.tv_title);
        iv_news = v.findViewById(R.id.iv_news);
    }
    public void setImage(String url){
        Picasso.get().load(url)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(iv_news);
    }
    public void setTitle(String title){
        tv_title.setText(title);
    }
    public void setName(String name){
        tv_name.setText(name);
    }
}