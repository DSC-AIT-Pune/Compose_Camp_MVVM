package com.example.compose_camp_mvvm.data

import com.example.compose_camp_mvvm.core.GithubRepository
import com.example.compose_camp_mvvm.core.GithubUser
import com.example.compose_camp_mvvm.data.client.GithubApiClient
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubApiClient: GithubApiClient
): GithubRepository {
    override suspend fun findUser(username: String): GithubUser? {
        try {
            val response = githubApiClient.findUser(username)
            return GithubUser(
                username = response.login,
                profileUrl = response.avatarUrl,
                type = response.type,
                name = response.name,
                companyName = response.companyName,
                location = response.location,
                bio = response.bio,
                reposCount = response.reposCount,
                followers = response.followers
            )
        } catch (error: Throwable) {
            return null
        }
    }
}