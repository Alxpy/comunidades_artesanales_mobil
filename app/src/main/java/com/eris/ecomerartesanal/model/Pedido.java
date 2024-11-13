package com.eris.ecomerartesanal.model;

import com.google.gson.annotations.SerializedName;

public class Pedido {

    @SerializedName("idPedido")
    private int idPedido;

    @SerializedName("fecha")
    private String fecha;

    @SerializedName("estado")
    private String estado;

    @SerializedName("total")
    private double total;

    @SerializedName("idCliente")
    private int idCliente;

    public Pedido() {}

    public Pedido(int idPedido, String fecha, String estado, double total, int idCliente) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.idCliente = idCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

}
