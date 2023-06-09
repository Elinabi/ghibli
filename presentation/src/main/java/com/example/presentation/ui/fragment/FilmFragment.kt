package com.example.presentation.ui.fragment

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentFilmBinding
import com.example.presentation.state.UIState
import com.example.presentation.ui.adapter.FilmAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FilmFragment : BaseFragment<FragmentFilmBinding, FilmViewModel>(R.layout.fragment_film)  {

    override val binding by viewBinding(FragmentFilmBinding::bind)
    override val viewModel: FilmViewModel by viewModels()
    private val filmAdapter = FilmAdapter()

    override fun initialize() {
        binding.animeRecView.adapter = filmAdapter
    }

    override fun setupSubscribes() {
        subscribeToFetchAnime()
    }

    private fun subscribeToFetchAnime() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.animeState.collect {
                    when (it) {
                        is UIState.Error -> {
                            Log.e("error", it.error)
                        }
                        is UIState.Loading -> {
                        }
                        is UIState.Success -> {
                            filmAdapter.submitList(it.data)
                        }
                    }
                }
            }
        }
    }
}