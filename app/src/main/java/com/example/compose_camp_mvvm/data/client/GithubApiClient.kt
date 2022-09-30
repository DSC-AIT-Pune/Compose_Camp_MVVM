package com.example.compose_camp_mvvm.data.client

import com.example.compose_camp_mvvm.data.model.GithubUserResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Inject

class GithubApiClient @Inject constructor(private val httpClient: HttpClient) {
        suspend fun findUser(username: String): GithubUserResponse {
            return httpClient.get(urlString = "https://api.github.com/users/$username").body()
        }
}

