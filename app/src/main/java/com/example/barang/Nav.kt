package com.example.barang

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun InventoryApp() {
    val navController = rememberNavController()

    val viewModel: InventoryViewModel = viewModel()

    NavHost(navController = navController, startDestination = "login_screen") {

        composable("login_screen") {
            LoginScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable("inventory_screen") {
            InventoryScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable("add_item_screen") {
            AddItemScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}