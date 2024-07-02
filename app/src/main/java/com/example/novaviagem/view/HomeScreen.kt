package com.example.novaviagem.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.novaviagem.model.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, state: State<User>) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Home") }) },
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
            innerPadding ->
        // Content of the Home screen
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            Text("Username: ${state.value.username}")
            Text("Email: ${state.value.email}")
        }
    }
}