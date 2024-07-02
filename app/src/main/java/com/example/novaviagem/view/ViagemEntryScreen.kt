package com.example.novaviagem.view

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.novaviagem.viewModel.ViagemViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ViagemEntryScreen(viewModel: ViagemViewModel) {
    var destino by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("") }
    var dataInicial by remember { mutableStateOf(TextFieldValue()) }
    var dataFinal by remember { mutableStateOf(TextFieldValue()) }
    var orcamento by remember { mutableStateOf("") }

    val dialog = MaterialDialog()

    dialog.build {
        datepicker { date ->
            val formattedDate = date.format(
                DateTimeFormatter.ofPattern("dd.MM.yyyy")
            )
            dataInicial = formattedDate
        }
    }

    val ctx = LocalContext.current

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
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
        Box {
            OutlinedTextField(
                value = dataInicial,
                onValueChange = { dataInicial = it },
                label = { Text("Data Inicial") }
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .alpha(0f)
                    .clickable(onClick = dialog.show()),
            )
        }

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
            viewModel.updateDestino(destino)
            viewModel.updateTipo(tipo)
            viewModel.updateDataInicial(LocalDate.now())
            viewModel.updateDataFinal(LocalDate.now())
            viewModel.updateOrcamento(orcamento.toDouble())
            viewModel.saveNew()
            Toast.makeText(ctx,
                "Product saved",
                Toast.LENGTH_SHORT).show()
        }) {
            Text("Salvar Viagem")
        }
    }
}