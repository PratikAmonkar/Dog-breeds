package com.example.dogsbreeds

import android.app.Application
import com.example.dogsbreeds.container.AppContainer
import com.example.dogsbreeds.container.AppDataContainer

class DogBreedsApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}