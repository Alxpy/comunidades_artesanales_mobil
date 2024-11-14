package com.eris.ecomerartesanal.HttpRequest;
import com.eris.ecomerartesanal.model.Delivery;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
public interface DeliveryService {
    @GET("delivery")
    Call<List<Delivery>> getDelivery();

    @GET("delivery/{id}")
    Call<Delivery> getDelivery(@Path("id") int id);

    @POST("delivery")
    Call<Delivery> createPedido(@Body Pedido pedido);

    @POST("login")
    Call<Delivery> getDelivery(email);

    @PUT("delivery/{id}")
    Call<Delivery> updatePedido(@Path("id") int id, @Body Delivery delivery);

    @DELETE("delivery/{id}")
    Call<Void> deletePedido(@Path("id") int id);
}
