package com.batuhanozkan.starwarsapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun StarWarsAPIcreater():StarWarsAPI{
        var starWarsApi = this.retrofit.create(StarWarsAPI::class.java)
        return starWarsApi;
    }
}