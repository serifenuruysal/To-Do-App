package com.soulkitchen.serifenuruysal.thetodoapp.data.repo

import androidx.lifecycle.LiveData
import com.soulkitchen.serifenuruysal.thetodoapp.data.db.TodoRecord

/**
 * Created by S.Nur Uysal on 2019-07-22.
 */

interface TodoRepo {
    fun saveTodo(todo: TodoRecord)
    fun updateTodo(todo: TodoRecord)
    fun deleteTodo(todo: TodoRecord)
    fun getAllTodoList(): LiveData<List<TodoRecord>>
}