package com.eris.ecomerartesanal;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonAPIService {
    @GET("pokemon/?limit=50")
    Call<PokemonFetchResults> getPokemons();

    @GET("pokemon/{nombre}")
    Call<Pokemon> getPokemon(@Path("nombre")String nombre);
}
