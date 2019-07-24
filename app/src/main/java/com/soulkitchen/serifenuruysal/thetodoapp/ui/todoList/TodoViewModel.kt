package com.soulkitchen.serifenuruysal.thetodoapp.ui.todoList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.soulkitchen.serifenuruysal.thetodoapp.data.db.TodoRecord
import com.soulkitchen.serifenuruysal.thetodoapp.data.repo.TodoRepo

/**
 * Created by S.Nur Uysal on 2019-07-22.
 */

class TodoViewModel(private val todoRepo: TodoRepo) : ViewModel() {

    fun saveTodo(todo: TodoRecord) {
        todoRepo.saveTodo(todo)
    }

    fun updateTodo(todo: TodoRecord){
        todoRepo.updateTodo(todo)
    }

    fun deleteTodo(todo: TodoRecord) {
        todoRepo.deleteTodo(todo)
    }

    fun getAllTodoList(): LiveData<List<TodoRecord>> {
        return todoRepo.getAllTodoList()
    }

}