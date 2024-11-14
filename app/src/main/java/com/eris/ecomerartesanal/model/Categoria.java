package com.eris.ecomerartesanal.model;
import com.google.gson.annotations.SerializedName;
public class Categoria {
    @SerializedName("idCategoria")
    private int idCategoria;
    @SerializedName("nombreCategoria")
    private String nombreCategoria;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Categoria() {
    }

    public Categoria(int idCategoria,String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria=nombreCategoria;
    }

}
