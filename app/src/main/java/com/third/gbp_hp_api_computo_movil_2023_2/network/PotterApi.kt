package com.third.gbp_hp_api_computo_movil_2023_2.network

import com.third.gbp_hp_api_computo_movil_2023_2.model.CharacterDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PotterApi {
    //https://hp-api.onrender.com/api/character/:id
    //https://hp-api.onrender.com/api/characters/students
    @GET("api/character/{id}")
    fun getCharacterDetail(
        @Path("id") id: String?

    ): Call<ArrayList<CharacterDetails>>
}