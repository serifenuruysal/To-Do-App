package com.soulkitchen.serifenuruysal.thetodoapp.di

import androidx.room.Room
import com.soulkitchen.serifenuruysal.thetodoapp.data.db.TodoDatabase
import com.soulkitchen.serifenuruysal.thetodoapp.data.repo.TodoRepo
import com.soulkitchen.serifenuruysal.thetodoapp.data.repo.TodoRepoImpl
import com.soulkitchen.serifenuruysal.thetodoapp.ui.todoList.TodoViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by S.Nur Uysal on 2019-07-22.
 */

val applicationModule = module {

    // Room database
    single {
        Room.databaseBuilder(androidApplication(),
            TodoDatabase::class.java,
           "todo_db")
            .build()
    }

    // TodoDao
    single { get<TodoDatabase>().todoDao() }

    // TodoRepository
    factory<TodoRepo> { TodoRepoImpl(get()) }

    // TodoViewModel
    viewModel { TodoViewModel(get()) }
}