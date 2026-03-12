package com.example.wishlistapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wishlistapp.ScreenRoutes
import com.example.wishlistapp.view.AddWishListItem
import com.example.wishlistapp.view.WishlistScreen
import com.example.wishlistapp.viewmodel.WishListViewModel

@Composable
fun AppNavigation(
    navController: NavHostController,
    viewModel: WishListViewModel,
) {

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.WishlistScreen.route
    ) {

        composable(ScreenRoutes.WishlistScreen.route) {
            WishlistScreen( viewModel = viewModel , {
                navController.navigate(ScreenRoutes.AddItemScreen.route)
            } )
        }

        composable(ScreenRoutes.AddItemScreen.route) {
            AddWishListItem(viewModel = viewModel ,
                navigateToWishlist = {
                    navController.popBackStack()
                }
            )
        }

    }
}