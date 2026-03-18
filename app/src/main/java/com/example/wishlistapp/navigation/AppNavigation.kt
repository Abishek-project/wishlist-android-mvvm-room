package com.example.wishlistapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wishlistapp.ScreenRoutes
import com.example.wishlistapp.view.AddWishListItem
import com.example.wishlistapp.view.UpdateWishListItem
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
            },
                { id, title, description ->
                    navController.navigate(ScreenRoutes.UpdateItemScreen.route + "/$id/$title/$description")
                }


            )
        }

        composable(ScreenRoutes.AddItemScreen.route) {
            AddWishListItem(viewModel = viewModel ,
                navigateToWishlist = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = ScreenRoutes.UpdateItemScreen.route + "/{id}/{title}/{description}"
        ) { backStackEntry ->

            val id = backStackEntry.arguments?.getString("id")?.toInt() ?: 0
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""

            UpdateWishListItem(
                viewModel = viewModel,
                id = id,
                title = title,
                description = description,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

    }
}