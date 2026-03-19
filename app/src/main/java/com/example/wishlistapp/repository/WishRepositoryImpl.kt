package com.example.wishlistapp.repository

import com.example.wishlistapp.data.local.WishListDao
import com.example.wishlistapp.model.WishListModel
import kotlinx.coroutines.flow.Flow

class WishRepositoryImpl(private  val wishListDao: WishListDao) : WishListRepository {
//    private val wishListItems = mutableListOf<WishListModel>()

    override suspend fun addItem(item: WishListModel) {
//        wishListItems.add(item)
        wishListDao.addItem(item)
    }

    override  fun getWishListItems(): Flow<List<WishListModel>> {
        return wishListDao.getAllItems()
//        return wishListItems
    }

    override suspend fun updateItem(item: WishListModel) {
//        val index = wishListItems.indexOfFirst { it.id == item.id }
//
//        if (index != -1) {
//            wishListItems[index] = item
//        }

        wishListDao.updateItem(item)
    }

    override suspend fun deleteItem(item: WishListModel) {
//        wishListItems.removeIf { it.id == item.id }
        wishListDao.deleteItem(item)
    }

    override  fun getWishById(id: Long): Flow<WishListModel?> {
        return wishListDao.getItemById(id)
    }
}


