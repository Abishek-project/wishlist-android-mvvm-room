package com.example.wishlistapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wishlistapp.ScreenRoutes
import com.example.wishlistapp.navigation.AppNavigation
import com.example.wishlistapp.viewmodel.WishListViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistScreen( viewModel: WishListViewModel , navigateToAddItem: () -> Unit , navigateToUpdateItem: (id: Int, title: String, description: String) -> Unit){

    val wishListItems = viewModel.wishListItems

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Wishlist" , color = Color.White, fontWeight = FontWeight.Medium) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2563EB)
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                  navigateToAddItem()
                },
                containerColor = Color(0xFF2563EB)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    tint = Color.White,
                    contentDescription = "Add"
                )
            }
        },
        containerColor = Color(0xFFF8FAFC)
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        ) {

            items(wishListItems.size) {
                val item = wishListItems[it]

                WishListCard(
                    title = item.title,
                    description = item.description,
                    onClick = {
                        navigateToUpdateItem(item.id, item.title, item.description)
                    },
                    onDelete = {
                        viewModel.deleteItem(item)
                    }
                )
            }

        }

    }

}

@Composable
fun WishListCard(title: String, description: String , onClick: () -> Unit ,     onDelete: () -> Unit ) {
    Card(
        modifier = Modifier.padding(10.dp),
        onClick = onClick


    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(10.dp).fillMaxSize()
        ) {

            //  Title + Delete icon row
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                IconButton(onClick = {
                    onDelete()
                }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = Color.Red
                    )
                }
            }

            Text(
                text = description
            )
            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}

