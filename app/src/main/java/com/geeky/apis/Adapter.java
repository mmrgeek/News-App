package com.geeky.apis;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by Mostafa on 3/23/2018.
 */

public class Adapter extends RecyclerView.Adapter<DataViewHolder> {
    private Context context;
    private ArrayList<JsonDataModel> list;


    public Adapter(Context context, JSONObject response) throws JSONException {
        super();
        this.context = context;
        JSONArray array = response.getJSONArray("articles");
        JsonParser jsonParser = new JsonParser();
        jsonParser.ParseJson(array);
        list = jsonParser.getArraylist();
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);
        DataViewHolder holder = new DataViewHolder(item);
        return holder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        JsonDataModel model = list.get(position);
        holder.setImage(model.getUrlToImage());
        holder.setTitle(model.getTitle());
        holder.setName(model.getSource().getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}