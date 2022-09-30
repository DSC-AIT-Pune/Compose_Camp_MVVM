package com.example.compose_camp_mvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose_camp_mvvm.core.GithubRepository
import com.example.compose_camp_mvvm.data.GithubRepositoryImpl
import com.example.compose_camp_mvvm.data.client.GithubApiClient
import com.example.compose_camp_mvvm.data.client.client
import com.example.compose_camp_mvvm.ui.theme.Compose_Camp_MVVMTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_Camp_MVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }



        CoroutineScope(Dispatchers.IO).launch {
            Log.d("APICall","${GithubRepositoryImpl(GithubApiClient(client)).findUser("john")}")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose_Camp_MVVMTheme {
        Greeting("Android")
    }
}