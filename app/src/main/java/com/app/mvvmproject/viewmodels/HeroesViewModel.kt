package com.app.mvvmproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.mvvmproject.data.model.HeroesData
import com.app.mvvmproject.data.repositories.HeroesRepo
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class HeroesViewModel constructor(private val repository: HeroesRepo) : ViewModel() {
    val heroesList = MutableLiveData<List<HeroesData>>()
    val errorMsg = MutableLiveData<String>()
    fun getAllHeroes(){
        val response = repository.getHeroesData()
        response.enqueue(object : Callback<List<HeroesData>> {
            override fun onResponse(
                call: Call<List<HeroesData>>,
                response: Response<List<HeroesData>>
            ) {
                heroesList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<HeroesData>>, t: Throwable) {
                errorMsg.postValue(t.message)
            }
        })
    }
}