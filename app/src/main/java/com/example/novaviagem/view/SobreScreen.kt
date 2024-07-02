package com.example.novaviagem.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SobreScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Sobre") }) },
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        // Content of the Developer Details screen
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            Text("Página do desenvolvedor")
            Text("Nome: Luan")
        }
    }
}