package com.soulkitchen.serifenuruysal.thetodoapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created by S.Nur Uysal on 2019-07-22.
 */

@Dao
interface TodoDao {

    @Insert
    suspend fun saveTodo(todoRecord: TodoRecord)

    @Delete
    suspend fun deleteTodo(todoRecord: TodoRecord)

    @Update
    suspend fun updateTodo(todoRecord: TodoRecord)

    @Query("SELECT * FROM todo ORDER BY id DESC")
    fun getAllTodoList(): LiveData<List<TodoRecord>>
}