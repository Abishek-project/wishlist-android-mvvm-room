package com.example.wishlistapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wishlistapp.model.WishListModel

@Database(
    entities = [WishListModel::class],
    version = 1,
    exportSchema = false

)
abstract class WishDataBase : RoomDatabase() {
    abstract fun wishlistDao(): WishListDao

}