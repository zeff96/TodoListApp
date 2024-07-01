package com.example.todolistapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel: ViewModel() {
    private var _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>> = _todoList

    fun getAllTodos(){
        _todoList.value = TodoManager.getAllTodos().reversed()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title: String){
        TodoManager.addTodo(title)
        getAllTodos()
    }

    fun deleteTodo(id: Int){
        TodoManager.deleteTodo(id)
        getAllTodos()
    }
}