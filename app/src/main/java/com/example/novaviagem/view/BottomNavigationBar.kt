package com.example.novaviagem.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = false,
            onClick = { navController.navigate("home") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Check, contentDescription = "Viagem") },
            label = { Text("Viagem") },
            selected = false,
            onClick = { navController.navigate("viagem") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Info, contentDescription = "Sobre") },
            label = { Text("Sobre") },
            selected = false,
            onClick = { navController.navigate("sobre") }
        )
    }
}