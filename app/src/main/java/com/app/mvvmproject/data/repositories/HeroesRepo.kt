package com.app.mvvmproject.data.repositories

import com.app.mvvmproject.data.network.RetrofitService

class HeroesRepo constructor(private val retrofitService: RetrofitService) {
    fun getHeroesData() = retrofitService.getHeroes()
}