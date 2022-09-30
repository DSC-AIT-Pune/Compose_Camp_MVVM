package com.example.compose_camp_mvvm.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.asj.example.ui.components.GithubUserProfile
import com.asj.example.ui.components.UsernameSearch
import com.example.compose_camp_mvvm.ui.GithubSearchViewModel
import com.example.compose_camp_mvvm.ui.components.BottomText

@Composable
fun GithubSearchScreen(viewModel: GithubSearchViewModel) {
    val state by viewModel.state.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        UsernameSearch(onSearch = { username -> viewModel.searchUser(username) })

        state.user?.let { GithubUserProfile(it) }

        if (state.isLoading) {
            CircularProgressIndicator()
        }
        state.errorMessage?.let { Text(it, color = Color.Red) }
        
        Spacer(modifier = Modifier.weight(1f))
        BottomText()
    }
}

