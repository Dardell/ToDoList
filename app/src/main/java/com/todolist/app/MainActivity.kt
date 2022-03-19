package com.todolist.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = ToDoAdapter(mutableListOf())

        rvTodoList.adapter = todoAdapter
        rvTodoList.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener{
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = ToDo(todoTitle)
                todoAdapter.addToDo(todo)
                etTodoTitle.text.clear()
            }
        }
        btnDeleteItem.setOnClickListener{
            todoAdapter.deleteDoneTodos()
        }
    }
}