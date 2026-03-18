package com.example.wishlistapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wishlistapp.repository.WishListRepository
import com.example.wishlistapp.model.WishListModel
import com.example.wishlistapp.repository.WishRepositoryImpl

class WishListViewModel(
    private val repository: WishListRepository = WishRepositoryImpl()
) : ViewModel() {
    private val _wishListItems = mutableListOf<WishListModel>()
    val wishListItems: List<WishListModel> = _wishListItems

    init {
        _wishListItems.addAll(repository.getWishListItems())
    }
    fun addItem(item: WishListModel) {
        repository.addItem(item)
        _wishListItems.add(item)
    }

    fun updateItem(item: WishListModel) {
        repository.updateItem(item)

        val index = _wishListItems.indexOfFirst { it.id == item.id }
        if (index != -1) {
            _wishListItems[index] = item
        }
    }

    fun deleteItem(item: WishListModel) {
        repository.deleteItem(item)
        _wishListItems.remove(item)
    }

}