package com.example.compose_camp_mvvm.core

data class GithubUser(
    val username: String,
    val profileUrl: String,
    val type: String,
    val name: String,
    val companyName: String?,
    val location: String?,
    val bio: String?,
    val reposCount: Int,
    val followers: Int
)
