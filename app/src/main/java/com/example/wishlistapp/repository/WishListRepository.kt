package com.example.wishlistapp.repository

import com.example.wishlistapp.model.WishListModel
import kotlinx.coroutines.flow.Flow


interface WishListRepository {
   suspend fun addItem(item: WishListModel){}
      fun getWishListItems(): Flow<List<WishListModel>>


    suspend  fun updateItem(item: WishListModel){}

    suspend  fun deleteItem(item: WishListModel)


     fun  getWishById(id: Long): Flow<WishListModel?>

}
