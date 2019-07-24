package com.soulkitchen.serifenuruysal.thetodoapp.ui

import android.app.Application
import com.soulkitchen.serifenuruysal.thetodoapp.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

/**
 * Created by S.Nur Uysal on 2019-07-22.
 */

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        //Initialising Koin
        startKoin {
            androidContext(this@BaseApp)
            modules(applicationModule)
            androidFileProperties()
        }
    }
}