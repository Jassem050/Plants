package com.jassemdev.android.plants

import android.app.Application
import com.jassemdev.android.plants.di.components.DaggerApplicationComponent

class PlantsApplication(): Application() {

    val applicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext) }
}