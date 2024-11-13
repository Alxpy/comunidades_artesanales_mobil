package com.eris.ecomerartesanal.HttpRequest;

import com.eris.ecomerartesanal.model.Pedido;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PedidoService {

    @GET("pedidos")
    Call<List<Pedido>> getPedidos();

    @GET("pedido/{id}")
    Call<Pedido> getPedido(@Path("id") int id);

    @POST("pedido")
    Call<Pedido> createPedido(@Body Pedido pedido);

    @PUT("pedido/{id}")
    Call<Pedido> updatePedido(@Path("id") int id, @Body Pedido pedido);

    @DELETE("pedido/{id}")
    Call<Void> deletePedido(@Path("id") int id);


}
