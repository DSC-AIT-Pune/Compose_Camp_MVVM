package com.asj.example.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose_camp_mvvm.core.GithubRepository
import com.example.compose_camp_mvvm.ui.GithubSearchViewModel
import com.example.compose_camp_mvvm.ui.theme.AppTheme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject



@Composable
fun UsernameSearch(onSearch: (String) -> Unit) {
    var username by remember { mutableStateOf("") }

    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = { newValue -> username = newValue },
            placeholder = {
                if (username.isBlank()) {
                    Text("Username")
                }
            }
        )
        Button(onClick = { onSearch(username) }) {
            Text("Search")
        }
    }
}

@Preview
@Composable
fun PreviewUsernameSearch() {
    AppTheme {
        UsernameSearch({})
    }
}