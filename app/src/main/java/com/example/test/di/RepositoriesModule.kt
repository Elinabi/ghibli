package com.example.test.di

import com.example.data.remote.repository.FilmRepositoryImpl
import com.example.domain.repoitory.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun provideMangaRepository(repositoryImpl: FilmRepositoryImpl): FilmRepository

}