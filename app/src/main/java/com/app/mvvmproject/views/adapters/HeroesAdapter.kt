package com.app.mvvmproject.views.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.app.mvvmproject.data.model.HeroesData
import com.bumptech.glide.Glide
import com.app.mvvmproject.databinding.RecyclerviewLayoutBinding

class HeroesAdapter : RecyclerView.Adapter<MainViewHolder>() {
    private var heroes = mutableListOf<HeroesData>()
    fun setHeroesList(heroes: List<HeroesData>) {
        this.heroes = heroes.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewLayoutBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val hero = heroes[position]
        holder.binding.textview.text = hero.name
        Log.d("Adapter", "onBindViewHolder: ${hero.imageurl}")
        Glide.with(holder.itemView.context)
            .load(hero.imageurl).into(holder.binding.imageView)
    }

    override fun getItemCount() = heroes.size
}

class MainViewHolder(val binding: RecyclerviewLayoutBinding) :
    RecyclerView.ViewHolder(binding.root)
