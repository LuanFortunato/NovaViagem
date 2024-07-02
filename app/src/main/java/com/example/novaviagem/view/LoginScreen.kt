package com.example.novaviagem.view

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.novaviagem.model.User
import com.example.novaviagem.viewModel.UserViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController, state: State<User>, userViewModel: UserViewModel) {
    val ctx = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = state.value.email,
            onValueChange ={ userViewModel.updateEmail(it)},
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = state.value.password,
            onValueChange = { userViewModel.updatePassword(it) },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                MainScope().launch {

                val user = userViewModel.login(email = state.value.email, password = state.value.password)
                    if (user != null) {
                        navController.navigate("home")
                        userViewModel.updateUsername(user.username)
                        userViewModel.updateEmail(user.email)
                    } else{
                        Toast.makeText(ctx,
                            "Usuario ou senha errados",
                            Toast.LENGTH_SHORT).show()

                    }
                }

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
        Button(
            onClick = {
                navController.navigate("register")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar-se")
        }
    }
}