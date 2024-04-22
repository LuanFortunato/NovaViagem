package com.example.novaviagem.viewModel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.example.novaviagem.model.Viagem

class ViagemViewModel : ViewModel() {

    var destino: String = ""
    var tipo: String = ""
    var dataInicial: String = ""
    var dataFinal: String = ""
    var orcamento: Double = 0.0

    private val viagens = mutableListOf<Viagem>()

    fun saveTrip() {
        val viagem = Viagem(
            destino,
            tipo,
            dataInicial,
            dataFinal,
            orcamento
        )
        viagens.add(viagem)
    }

    fun getViagem() = viagens
}