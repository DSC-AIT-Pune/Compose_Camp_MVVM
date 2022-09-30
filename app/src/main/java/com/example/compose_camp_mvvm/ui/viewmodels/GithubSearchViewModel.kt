package com.example.compose_camp_mvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asj.example.ui.components.GithubUserUiModel
import com.example.compose_camp_mvvm.core.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class GithubSearchUiState(
    val isLoading: Boolean,
    val user: GithubUserUiModel?,
    val errorMessage: String?
)

@HiltViewModel
class GithubSearchViewModel @Inject constructor(
    private val repository: GithubRepository
) : ViewModel() {
    private val _state = MutableStateFlow(
        GithubSearchUiState(
            isLoading = false,
            user = null,
            errorMessage = null
        )
    )
    val state = _state.asStateFlow()

    fun searchUser(username: String) {

        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            val fetchedUser = repository.findUser(username)

            if (fetchedUser == null) {
                _state.update { it.copy(errorMessage = "Invalid username", user = null) }
            } else {
                val user = GithubUserUiModel(
                    username = fetchedUser.username,
                    profileUrl = fetchedUser.profileUrl,
                    type = fetchedUser.type,
                    name = fetchedUser.name,
                    companyName = fetchedUser.companyName,
                    location = fetchedUser.location,
                    bio = fetchedUser.bio,
                    reposCount = fetchedUser.reposCount,
                    followers = fetchedUser.followers
                )
                _state.update { it.copy(user = user) }
            }
            _state.update { it.copy(isLoading = false) }
        }
    }
}