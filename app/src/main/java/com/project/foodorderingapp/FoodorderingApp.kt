package com.project.foodorderingapp

import android.app.Application
import com.project.foodorderingapp.ui.theme.Graph

class FoodorderingApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(context = this)
    }
}