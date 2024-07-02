package com.example.novaviagem

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.novaviagem.db.AppDatabase
import com.example.novaviagem.model.Viagem
import com.example.novaviagem.view.ViagemScreen
import com.example.novaviagem.view.HomeScreen
import com.example.novaviagem.view.LoginScreen
import com.example.novaviagem.view.RegisterScreen
import com.example.novaviagem.view.SobreScreen
import com.example.novaviagem.view.ViagemEntryScreen
import com.example.novaviagem.viewModel.UserViewModel
import com.example.novaviagem.viewModel.UserViewModelFactory
import com.example.novaviagem.viewModel.ViagemViewModel
import com.example.novaviagem.viewModel.ViagemViewModelFactory

@Composable
fun MyApp() {

    val ctx = LocalContext.current

    val db = AppDatabase.getDatabase(ctx)

    val userViewModel: UserViewModel = viewModel(
        factory = UserViewModelFactory(db)
    )
    val viagemViewModel: ViagemViewModel = viewModel(
        factory =  ViagemViewModelFactory(db)
    )

    val userState = userViewModel.uiState.collectAsState()
    val viagemState = viagemViewModel.uiState.collectAsState()

    val navController = rememberNavController()

    NavHost(navController, startDestination = "login") {
        composable("login") { LoginScreen(navController, userState, userViewModel) }
        composable("register") { RegisterScreen(navController, userState, userViewModel) }
        composable("home") { HomeScreen(navController, userState) }
        composable("viagem") { ViagemScreen(viagemViewModel, navController) }
        composable("sobre") { SobreScreen(navController) }
        composable("entry") { ViagemEntryScreen(viagemViewModel) }
    }
}