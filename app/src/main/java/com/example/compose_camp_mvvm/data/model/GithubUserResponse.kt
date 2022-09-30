package com.example.compose_camp_mvvm.data.model


import kotlinx.serialization.*

@Serializable
data class GithubUserResponse(
    @SerialName("login")
    val login: String,

    @SerialName("avatar_url")
    val avatarUrl: String,

    @SerialName("type")
    val type: String,

    @SerialName("name")
    val name: String,

    @SerialName("company")
    val companyName: String?,

    @SerialName("location")
    val location: String?,

    @SerialName("bio")
    val bio: String?,

    @SerialName("public_repos")
    val reposCount: Int,

    @SerialName("followers")
    val followers: Int
)