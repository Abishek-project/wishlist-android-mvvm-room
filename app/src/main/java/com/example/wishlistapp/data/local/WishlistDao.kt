package com.example.wishlistapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.wishlistapp.model.WishListModel
import kotlinx.coroutines.flow.Flow

@Dao
interface WishListDao {

    @Insert
    suspend fun addItem(item: WishListModel)

    @Update
    suspend fun updateItem(item: WishListModel)

    @Delete
    suspend fun deleteItem(item: WishListModel)


    @Query("SELECT * FROM wishlist_items")
    fun getAllItems(): Flow<List<WishListModel>>

    @Query("SELECT * FROM wishlist_items WHERE id = :id")
     fun getItemById(id: Long): Flow<WishListModel?>

}