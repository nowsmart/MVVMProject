package com.app.mvvmproject.data.network

import com.app.mvvmproject.data.model.HeroesData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService:HeroesApi {
    @GET("marvel")
    override fun getHeroes(): Call<List<HeroesData>>
    companion object{
        private var retrofitService : RetrofitService? = null
        fun getInstance(): RetrofitService{
            if(retrofitService==null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://simplifiedcoding.net/demos/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}