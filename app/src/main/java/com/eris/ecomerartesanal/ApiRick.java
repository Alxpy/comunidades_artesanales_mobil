package com.eris.ecomerartesanal;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiRick {

    @GET("character/{id}")
    Call<Character> FIND(@Path("id") String id);

}
