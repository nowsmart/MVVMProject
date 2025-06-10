package com.app.mvvmproject.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.mvvmproject.data.repositories.HeroesRepo
import com.app.mvvmproject.viewmodels.HeroesViewModel

class ViewModelFactory constructor(private val repository: HeroesRepo) : ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HeroesViewModel::class.java)) {
            HeroesViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}