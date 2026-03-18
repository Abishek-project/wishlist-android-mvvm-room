package com.example.wishlistapp.repository

import com.example.wishlistapp.model.WishListModel


interface WishListRepository {
    fun addItem(item: WishListModel){}
    fun getWishListItems(): List<WishListModel>

    fun updateItem(item: WishListModel){}

    fun deleteItem(item: WishListModel)

}
