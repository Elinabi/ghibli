package com.example.data.remote.apiservices

import com.example.data.remote.dtos.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmApiServices {

    @GET("films")
    suspend fun fetchFilm(
        @Query("fields") fields: String = "",
        @Query("limit") limit: Int = 50
    ) : List<ResponseDto>
}