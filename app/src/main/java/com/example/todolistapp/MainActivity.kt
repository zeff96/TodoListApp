package com.example.todolistapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.todolistapp.ui.theme.TodoListAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val dataModel = ViewModelProvider(this)[TodoViewModel::class.java]
        setContent {
            TodoListAppTheme {
               Scaffold(
                   topBar = {
                       TopAppBar(
                           colors = topAppBarColors(
                               titleContentColor = MaterialTheme.colorScheme.primary
                           ),
                           title = {
                               Text(text = "Tasks")
                           }
                       )
                   }
               ) {innerPadding->
                   TodoListPage(
                       dataModel,
                       modifier = Modifier.padding(innerPadding)
                   )
               }
            }
        }
    }
}
