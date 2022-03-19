package com.todolist.app

data class ToDo(
    val title: String,
    var isChecked: Boolean = false
)