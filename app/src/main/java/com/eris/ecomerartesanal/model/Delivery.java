package com.eris.ecomerartesanal.model;
import com.google.gson.annotations.SerializedName;
public class Delivery {
    @SerializedName("idDelivery")
    private int idDelivery;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("turno")
    private String turno;

    @SerializedName("email")
    private String email;

    @SerializedName("estado")
    private String estado;

    @SerializedName("ubicacion")
    private String ubicacion;

    @SerializedName("password")
    private String password;

    public int getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(int idDelivery) {
        this.idDelivery = idDelivery;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Delivery() {
    }
    public Delivery(int idDelivery,String nombre,String turno,String email,String estado,String ubicacion,String password) {
        this.idDelivery=idDelivery;
        this.nombre=nombre;
        this.turno=turno;
        this.email=email;
        this.estado=estado;
        this.ubicacion=ubicacion;
        this.password=password;
    }

}
