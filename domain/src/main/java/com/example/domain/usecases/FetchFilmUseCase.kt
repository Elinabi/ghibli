package com.example.domain.usecases

import com.example.domain.repoitory.FilmRepository
import javax.inject.Inject

class FetchFilmUseCase @Inject constructor(
    private val filmRepository: FilmRepository
){
    operator fun invoke() = filmRepository.fetchFilm()
}