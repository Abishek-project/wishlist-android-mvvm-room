package com.example.wishlistapp.view

import com.example.wishlistapp.viewmodel.WishListViewModel
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateWishListItem(
    viewModel: WishListViewModel,
    id: Int,
    title: String,
    description: String,
    navigateBack: () -> Unit
) {
    val context = LocalContext.current

    var updatedTitle by remember { mutableStateOf(title) }
    var updatedDescription by remember { mutableStateOf(description) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Update Item", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = navigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2563EB)
                )
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp)
        ) {

            OutlinedTextField(
                value = updatedTitle,
                onValueChange = { updatedTitle = it },
                label = { Text("Title") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = updatedDescription,
                onValueChange = { updatedDescription = it },
                label = { Text("Description") }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    if (updatedTitle.isNotEmpty() && updatedDescription.isNotEmpty()) {

                        val updatedItem = WishListModel(
                            id = id.toLong(),
                            title = updatedTitle,
                            description = updatedDescription
                        )

                        viewModel.updateItem(updatedItem)

                        navigateBack()
                    } else {
                        Toast.makeText(context, "Fill all fields", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Update Item")
            }
        }
    }
}