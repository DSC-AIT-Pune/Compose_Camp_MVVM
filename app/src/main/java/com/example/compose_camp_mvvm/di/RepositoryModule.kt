package com.example.compose_camp_mvvm.di

import com.example.compose_camp_mvvm.core.GithubRepository
import com.example.compose_camp_mvvm.data.GithubRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun githubRepository(impl: GithubRepositoryImpl): GithubRepository
}