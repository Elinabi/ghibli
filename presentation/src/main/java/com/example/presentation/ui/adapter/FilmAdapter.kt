package com.example.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.databinding.ItemFilmBinding
import com.example.presentation.models.ResponseUi

class FilmAdapter : ListAdapter<ResponseUi, FilmAdapter.AnimeViewHolder>(
    diffUtil
) {

    inner class AnimeViewHolder(private val binding: ItemFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(dataItem: ResponseUi) {
            binding.tvKitsu.text = dataItem.originalTitle
            binding.tvKitsu1.text = dataItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ResponseUi>() {
            override fun areItemsTheSame(oldItem: ResponseUi, newItem: ResponseUi): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ResponseUi, newItem: ResponseUi): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}