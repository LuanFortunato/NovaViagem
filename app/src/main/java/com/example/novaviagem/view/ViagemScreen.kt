package com.example.novaviagem.view

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.novaviagem.model.Viagem
import com.example.novaviagem.viewModel.ViagemViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViagemScreen(viagemViewModel: ViagemViewModel, navController: NavController){

    val ctx = LocalContext.current
    val viagens = viagemViewModel.getAll().collectAsState(initial = emptyList())


    Scaffold(
        topBar = { TopAppBar(title = { Text("Sobre") }) },
        bottomBar = { BottomNavigationBar(navController) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("entry")
            }) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription ="" )
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {

            LazyColumn() {
                items(items = viagens.value) {
                    ViagemCard(it)
                }
            }

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViagemCard(p: Viagem) {
    val ctx = LocalContext.current
    Card(elevation = CardDefaults.cardElevation(
        defaultElevation = 4.dp
    ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = {
                    Toast
                        .makeText(
                            ctx,
                            "Viagem: ${p.destino}",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                },
                onLongClick = {
                    Toast
                        .makeText(
                            ctx,
                            "Excluir viagem? ",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                }
            )
    ) {

        Column(modifier = Modifier.padding(4.dp) ) {
            Text(text = p.destino,
                style = MaterialTheme.typography.titleLarge)
            Text(text = "R$ ${p.orcamento}",
                style = MaterialTheme.typography.bodySmall)
        }

    }
}

