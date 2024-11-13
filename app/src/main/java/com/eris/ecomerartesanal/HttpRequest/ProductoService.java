package com.eris.ecomerartesanal.HttpRequest;

import com.eris.ecomerartesanal.Activitys.ProductoActivity;
import com.eris.ecomerartesanal.model.ProductoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProductoService {

    @GET("productos")
    Call<List<ProductoModel>> getProductos();

    @GET("producto/{id}")
    Call<ProductoModel> getProducto(@Path("id") int id);

    @POST("producto")
    Call<ProductoModel> createProducto(@Body ProductoModel producto);

    @PUT("producto")
    Call<ProductoModel> updateProducto(@Path("id")int id, @Body ProductoModel producto);

    @DELETE("producto/{id}")
    Call<Void> deleteProducto(@Path("id") int id);

}
