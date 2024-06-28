package com.example.todolistapp

import java.util.Date

interface TodoList {
    fun AddTodos(id: String, name: String, createdAt: Date);

    fun GetTodos();

    fun DeleteTodo(id: String);
}