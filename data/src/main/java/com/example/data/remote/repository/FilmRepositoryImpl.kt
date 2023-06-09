package com.example.data.remote.repository

import com.example.data.remote.apiservices.FilmApiServices
import com.example.data.remote.dtos.toDomain
import com.example.data.remote.repository.base.BaseRepository
import com.example.domain.repoitory.FilmRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilmRepositoryImpl @Inject constructor(
    private val filmApiServices: FilmApiServices
): BaseRepository(),FilmRepository{

    override fun fetchFilm() = doRequest {
        filmApiServices.fetchFilm().map{
            it.toDomain()
        }
    }
}