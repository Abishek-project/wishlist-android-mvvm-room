package com.example.wishlistapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishlistapp.Graph
import com.example.wishlistapp.repository.WishListRepository
import com.example.wishlistapp.model.WishListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishListViewModel(
    private val wishListRepository: WishListRepository = Graph.wishListRepository
) : ViewModel() {
//    private val _wishListItems = mutableStateListOf<WishListModel>()
//    val wishListItems: List<WishListModel> = _wishListItems
      lateinit var getAllItems: Flow<List<WishListModel>>

    init {
        loadWishListItems()
    }

    private fun loadWishListItems() {
        viewModelScope.launch {
            getAllItems = wishListRepository.getWishListItems()
        }

    }
    fun addItem(item: WishListModel) {

        viewModelScope.launch(Dispatchers.IO) {
            wishListRepository.addItem(item)
        }
//        wishListRepository.addItem(item)
//        _wishListItems.add(item)
    }

    fun updateItem(item: WishListModel) {
        viewModelScope.launch(Dispatchers.IO) {
            wishListRepository.updateItem(item)
        }

//        wishListRepository.updateItem(item)
//
//        val index = _wishListItems.indexOfFirst { it.id == item.id }
//        if (index != -1) {
//            _wishListItems[index] = item
//        }
    }

    fun deleteItem(item: WishListModel) {
        viewModelScope.launch(Dispatchers.IO) {
            wishListRepository.deleteItem(item)
        }

//        wishListRepository.deleteItem(item)
//        _wishListItems.remove(item)

    }

    fun getItemById(id:Long){
        viewModelScope.launch(Dispatchers.IO) {
            wishListRepository.getWishById(id)
        }

    }

}