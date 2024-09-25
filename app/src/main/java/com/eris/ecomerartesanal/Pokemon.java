package com.eris.ecomerartesanal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("base_experience")
    @Expose
    private String base_experience;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase_experience(){ return base_experience; }

    public void setBase_experience (String base_experience) { this.base_experience = base_experience; }

    public String getDescription() {
        return "It's " + getName() + "!";
    }
}
