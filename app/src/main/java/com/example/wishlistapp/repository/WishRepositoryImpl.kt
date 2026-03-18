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

    override fun updateItem(item: WishListModel) {
        val index = wishListItems.indexOfFirst { it.id == item.id }

        if (index != -1) {
            wishListItems[index] = item
        }
    }

    override fun deleteItem(item: WishListModel) {
        wishListItems.removeIf { it.id == item.id }
    }
}


