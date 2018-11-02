package com.geeky.apis;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {
    private ArrayList<JsonDataModel> list;


    public ArrayList<JsonDataModel> getArraylist(){
        return list;
    }

    public void ParseJson(JSONArray jsonArray) throws JSONException {
        list = new ArrayList<>();
        for (int i = 0; i < 20;i++) {
            JsonDataModel mode = new JsonDataModel();


            JSONObject object = jsonArray.getJSONObject(i);

            mode.setTitle(object.getString("title"));
            mode.setUrl(object.getString("url"));
            mode.setUrlToImage(object.getString("urlToImage"));
            mode.setAuthor(object.getString("author"));
            mode.setDescription(object.getString("description"));
            mode.setPublishedAt(object.getString("publishedAt"));

            mode.setSource(new Source(object.getJSONObject("source").getString("id"),
                    object.getJSONObject("source").getString("name")));

            list.add(mode);
        }
    }
}