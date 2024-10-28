package com.project.foodorderingapp.ui.theme

import android.content.Context
import com.project.foodorderingapp.model.DataStoreManager

object Graph {
    lateinit var dataStoreManager: DataStoreManager

    fun provide(context: Context) {
        dataStoreManager = DataStoreManager(context)
    }
}