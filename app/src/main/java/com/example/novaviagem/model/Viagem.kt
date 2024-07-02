package com.example.novaviagem.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.Date
@Entity
data class Viagem(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val destino: String = "",
    val tipo: String = "",
    val dataInicial: LocalDate = LocalDate.now(),
    val dataFinal: LocalDate = LocalDate.now(),
    val orcamento: Double = 0.0
)
