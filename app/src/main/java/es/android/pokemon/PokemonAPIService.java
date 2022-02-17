package es.android.pokemon;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonAPIService {

    @GET("pokemon/?limit=1000")
    Call<PokemonFetchResults> getPokemons();
}
