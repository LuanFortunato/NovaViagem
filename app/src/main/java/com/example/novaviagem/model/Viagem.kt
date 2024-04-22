package com.example.novaviagem.model

data class Viagem(
    val destino: String,
    val tipo: String,
    val dataInicial: String,
    val dataFinal: String,
    val orcamento: Double
)
