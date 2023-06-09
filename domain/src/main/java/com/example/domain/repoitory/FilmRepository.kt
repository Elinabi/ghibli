package com.example.domain.repoitory

import com.example.domain.either.Either
import com.example.domain.models.Response
import kotlinx.coroutines.flow.Flow

interface FilmRepository {

    fun fetchFilm(): Flow<Either<String, List<Response>>>
}