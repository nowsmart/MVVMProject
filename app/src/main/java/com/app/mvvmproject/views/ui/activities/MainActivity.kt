package com.app.mvvmproject.views.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.mvvmproject.data.ViewModelFactory
import com.app.mvvmproject.data.network.RetrofitService
import com.app.mvvmproject.data.repositories.HeroesRepo
import com.app.mvvmproject.viewmodels.HeroesViewModel
import com.app.mvvmproject.views.adapters.HeroesAdapter
import com.app.mvvmproject.R
import com.app.mvvmproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: HeroesViewModel
    private val retrofitService = RetrofitService.getInstance()
    private val adapter = HeroesAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.recyclerView.setLayoutManager(LinearLayoutManager(this))
        viewModel = ViewModelProvider(this, ViewModelFactory(HeroesRepo(retrofitService)))[HeroesViewModel::class.java]
        binding.recyclerView.adapter = adapter
        viewModel.heroesList.observe(this, Observer{
            Log.d("MainActivity", "onCreate, $it")
            adapter.setHeroesList(it)
        })
        viewModel.errorMsg.observe(this, Observer {

        })
        viewModel.getAllHeroes()
    }
}