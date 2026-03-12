package com.example.wishlistapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wishlistapp.repository.WishListRepository
import com.example.wishlistapp.model.WishListModel
import com.example.wishlistapp.repository.WishListRepositoryImpl

class WishListViewModel(
    private val repository: WishListRepository = WishListRepositoryImpl()
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

}