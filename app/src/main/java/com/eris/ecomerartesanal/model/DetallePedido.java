package com.eris.ecomerartesanal.model;
import com.google.gson.annotations.SerializedName;
public class DetallePedido {

    @SerializedName("idDetalle")
    private Integer idDetalle;

    @SerializedName("idPedido")
    private int idPedido;

    @SerializedName("idProducto")
    private int idProducto;

    @SerializedName("cantidad")
    private int cantidad;

    @SerializedName("subtotal")
    private float subtotal;

    // Constructor vacío
    public DetallePedido() {
    }

    // Constructor con todos los parámetros
    public DetallePedido(Integer idDetalle, int idPedido, int idProducto, int cantidad, float subtotal) {
        this.idDetalle = idDetalle;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    // Getters
    public Integer getIdDetalle() {
        return idDetalle;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }

    // Setters
    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
}
