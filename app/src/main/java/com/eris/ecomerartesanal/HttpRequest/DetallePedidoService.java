package com.eris.ecomerartesanal.HttpRequest;

import com.eris.ecomerartesanal.model.DetallePedido;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
public interface DetallePedidoService {
    @GET("detallepedido")
    Call<List<DetallePedido>> getDetallepedido();
    @GET("detallepedido/{id}")
    Call<DetallePedido> getDetallepedido(@Path("id") int id);

    @POST("detallepedido")
    Call<DetallePedido> createDetallepedido(@Body DetallePedido detallepedido);

    @PUT("detallepedido/{id}")
    Call<DetallePedido> updateDetallepedido(@Path("id") int id, @Body DetallePedido detallepedido);

    @DELETE("detallepedido/{id}")
    Call<Void> deleteDetallepedido(@Path("id") int id);
}
