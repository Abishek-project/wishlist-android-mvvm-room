package com.example.wishlistapp

import android.app.Application

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}