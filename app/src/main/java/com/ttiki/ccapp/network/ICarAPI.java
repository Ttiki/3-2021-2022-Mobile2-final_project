package com.ttiki.ccapp.network;

import com.ttiki.ccapp.model.Caracter;
import com.ttiki.ccapp.model.CaracterDetail;
import com.ttiki.ccapp.model.Episode;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ICarAPI {
    @GET("characters/")
    Call<List<Caracter>> getAllCaracters();

    @GET("characters/{idCharacter}/")
    Call<CaracterDetail> getCharacterById(@Path("idCharacter") int id);

    @GET("characters/{idCharacter}/episodes")
    Call<List<Episode>> getEpisodesOfCharacter(@Path("idCharacter") int id);
}
