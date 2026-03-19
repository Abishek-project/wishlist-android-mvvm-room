package com.example.wishlistapp

import android.content.Context
import androidx.room.Room
import com.example.wishlistapp.data.local.WishDataBase
import com.example.wishlistapp.repository.WishListRepository
import com.example.wishlistapp.repository.WishRepositoryImpl

object Graph {

    // Database instance
    lateinit var database: WishDataBase

    // Repository
    val wishListRepository: WishListRepository by lazy {
        WishRepositoryImpl(wishListDao = database.wishlistDao())
    }

    // Initialize
    fun provide(context: Context) {
        database = Room.databaseBuilder(
            context.applicationContext,
            WishDataBase::class.java,
            "wishlist.db"
        ).build()
    }
}
