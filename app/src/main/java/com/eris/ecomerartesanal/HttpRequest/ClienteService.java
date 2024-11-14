package com.eris.ecomerartesanal.HttpRequest;

import com.eris.ecomerartesanal.model.Cliente;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
public interface ClienteService {
    @GET("cliente")
    Call<List<Cliente>> getCliente();

    @GET("cliente/{id}")
    Call<Cliente> getCliente(@Path("id") int id);

    @POST("cliente")
    Call<Cliente> createCliente(@Body Cliente cliente);

    @POST("login")
    Call<Cliente> getCliente(email);
    @PUT("cliente/{id}")
    Call<Cliente> updateCliente(@Path("id") int id, @Body Cliente cliente);

    @DELETE("cliente/{id}")
    Call<Void> deleteCliente(@Path("id") int id);

}
