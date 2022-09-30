package com.example.compose_camp_mvvm.core

interface GithubRepository {
    suspend fun findUser(username: String): GithubUser?
}