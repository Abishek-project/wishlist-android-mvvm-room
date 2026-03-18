package com.example.wishlistapp

sealed class ScreenRoutes(val route: String) {
    object WishlistScreen : ScreenRoutes("wishlist_screen")
    object AddItemScreen : ScreenRoutes("add_item_screen")

    object UpdateItemScreen : ScreenRoutes("update_item")
}