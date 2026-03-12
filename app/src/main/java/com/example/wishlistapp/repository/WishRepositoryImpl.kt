package com.example.wishlistapp.repository

import com.example.wishlistapp.model.WishListModel

class WishRepositoryImpl : WishListRepository {
    private val wishListItems = mutableListOf<WishListModel>()

    override fun addItem(item: WishListModel) {
        wishListItems.add(item)
    }

    override fun getWishListItems(): List<WishListModel> {
        return wishListItems
    }

}


