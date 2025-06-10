package com.app.mvvmproject.data.network

import com.app.mvvmproject.data.model.HeroesData
import retrofit2.Call
import retrofit2.http.GET

interface HeroesApi {
    @GET("marvel")
    fun getHeroes(): Call<List<HeroesData>>
}