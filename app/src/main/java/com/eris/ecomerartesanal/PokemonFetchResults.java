package com.eris.ecomerartesanal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PokemonFetchResults {
    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("results")
    @Expose
    private ArrayList results;

    public ArrayList getResults() {
        return results;
    }

}
