package com.example.presentation.ui.fragment

import androidx.lifecycle.viewModelScope
import com.example.domain.either.Either
import com.example.domain.usecases.FetchFilmUseCase
import com.example.presentation.base.BaseViewModel
import com.example.presentation.models.ResponseUi
import com.example.presentation.models.toUI
import com.example.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    private val fetchFilmUseCase: FetchFilmUseCase
) : BaseViewModel() {

    private val _animeState = MutableStateFlow<UIState<List<ResponseUi>>>(UIState.Loading())
    val animeState get() = _animeState.asStateFlow()

    init {
        fetchAnime()
    }

    private fun fetchAnime() {
        viewModelScope.launch {
            fetchFilmUseCase().collect {
                when (it) {
                    is Either.Left -> {
                        it.message?.let { error ->
                            _animeState.value = UIState.Error(error)
                        }
                    }
                    is Either.Right -> {
                        it.data?.let {
                            _animeState.value = UIState.Success(it.map { film ->
                                film.toUI()
                            })
                        }
                    }
                }
            }
        }
    }
}