package com.batuhanozkan.starwarsapp

import retrofit2.Call
import retrofit2.http.GET

public interface StarWarsAPI {
    @GET("people/1")
    fun getPeople(): Call<People>
}