package com.example.novaviagem.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.novaviagem.viewModel.ViagemViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ViagemEntryScreen(viewModel: ViagemViewModel = ViagemViewModel()) {
    var destino by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("") }
    var dataInicial by remember { mutableStateOf("") }
    var dataFinal by remember { mutableStateOf("") }
    var orcamento by remember { mutableStateOf("") }
    val snackbarHostState = remember { SnackbarHostState() }

    Column(modifier = Modifier.padding(16.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = destino,
            onValueChange = { destino = it },
            label = { Text("Destino") }
        )
        OutlinedTextField(
            value = tipo,
            onValueChange = { tipo = it },
            label = { Text("Tipo da Viagem") }
        )
        OutlinedTextField(
            value = dataInicial,
            onValueChange = { dataInicial = it },
            label = { Text("Data Inicial") },
        )
        OutlinedTextField(
            value = dataFinal,
            onValueChange = { dataFinal = it },
            label = { Text("Data Final") },
        )
        OutlinedTextField(
            value = orcamento,
            onValueChange = { orcamento = it },
            label = { Text("Orçamento") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(modifier = Modifier.padding(top = 20.dp),
            onClick = {
            viewModel.destino = destino
            viewModel.tipo = tipo
            viewModel.dataInicial = dataInicial
            viewModel.dataFinal = dataFinal
            viewModel.orcamento = orcamento.toDoubleOrNull() ?: 0.0
            viewModel.saveTrip()
            CoroutineScope(Dispatchers.Main).launch {
                snackbarHostState.showSnackbar("Viagem registrada")
            }
        }) {
            Text("Salvar Viagem")
        }
    }
    SnackbarHost(hostState = snackbarHostState)
}