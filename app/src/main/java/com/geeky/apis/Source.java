package com.geeky.apis;

/**
 * Created by Mostafa on 3/23/2018.
 */

public class Source {
    private String id;
    private String name;

    public Source(){}

    public Source(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
