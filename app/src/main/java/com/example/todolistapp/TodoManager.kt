package com.example.todolistapp

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date

object TodoManager {
    private val todoLists = mutableListOf<Todo>()

    fun getAllTodos(): List<Todo>{
        return todoLists
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title: String){
        todoLists.add(
            Todo(
                System.currentTimeMillis().toInt(),
                title,
                Date.from(Instant.now())
            )
        )
    }

    fun deleteTodo(id: Int){
        todoLists.removeIf {
            it.id == id
        }
    }
}