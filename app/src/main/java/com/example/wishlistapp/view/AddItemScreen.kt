package com.example.wishlistapp.view

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.wishlistapp.model.WishListModel
import com.example.wishlistapp.viewmodel.WishListViewModel
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddWishListItem(
    viewModel: WishListViewModel,
    navigateToWishlist: () -> Unit
) {
   val context = LocalContext.current
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Scaffold(

        topBar = {
            TopAppBar(
                title = { Text("Add Wishlist Item", color = Color.White) },

                navigationIcon = {
                    IconButton(onClick = navigateToWishlist) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2563EB)
                )
            )
        },

        containerColor = Color(0xFFF8FAFC)

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(20.dp)
        ) {
             Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Create a new wish",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(26.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {

                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {

                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Title") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text("Description") },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 3
                    )

                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                   if (
                       title.isNotEmpty() &&
                       description.isNotEmpty()
                   ){
                       val newItem = WishListModel(
                           id = Random.nextInt(),
                           title = title,
                           description = description
                       )

                       viewModel.addItem(newItem)
                       navigateToWishlist()

                   }
                    else{
                       Toast.makeText(
                           context,
                           "Please fill all the fields",
                           Toast.LENGTH_SHORT
                       ).show()
                   }


                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2563EB),
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            ) {
                Text("Add Item")
            }

        }
    }
}