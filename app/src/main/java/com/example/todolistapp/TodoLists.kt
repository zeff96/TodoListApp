package com.example.todolistapp

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date


data class Todo(val id: Int, val name: String, val createdAt: Date);


object SampleData{
    @RequiresApi(Build.VERSION_CODES.O)
    val sampleTodos = listOf(
        Todo(
            1,
            "My first todo",
            Date.from(Instant.now()),
        ),
        Todo(
            2,
            "My second todo",
            Date.from(Instant.now()),
        ),
        Todo(
            3,
            "My third todo",
            Date.from(Instant.now()),
        ),
        Todo(
            4,
            "My forth todo",
            Date.from(Instant.now()),
        ),
    )
}

