package com.example.novaviagem.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.novaviagem.dao.ViagemDao
import com.example.novaviagem.db.AppDatabase
import com.example.novaviagem.model.Viagem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Date

class ViagemViewModelFactory(val db: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return ViagemViewModel(db.viagemDao) as T
    }
}

class ViagemViewModel(val viagemDao: ViagemDao): ViewModel() {

    private val _uiState = MutableStateFlow(Viagem())
    val uiState: StateFlow<Viagem> = _uiState.asStateFlow()

    fun updateDestino(destino: String) {
        _uiState.update {
            it.copy(destino = destino)
        }
    }
    fun updateTipo(tipo: String) {
        _uiState.update {
            it.copy(tipo = tipo)
        }
    }
    fun updateDataInicial(dataInicial: LocalDate) {
        _uiState.update {
            it.copy(dataInicial = dataInicial)
        }
    }

    fun updateDataFinal(dataFinal: LocalDate) {
        _uiState.update {
            it.copy(dataFinal = dataFinal)
        }
    }

    fun updateOrcamento(orcamento: Double) {
        _uiState.update {
            it.copy(orcamento = orcamento)
        }
    }
    private fun updateId(id: Long) {
        _uiState.update {
            it.copy(id = id)
        }
    }

    private fun new() {
        _uiState.update {
            it.copy(id = 0, destino = "", tipo = "", dataInicial = LocalDate.now(), dataFinal = LocalDate.now(),  orcamento = 0.0,)
        }
    }

    fun save() {
        viewModelScope.launch {
            val id = viagemDao.upsert(uiState.value)
            if (id > 0) {
                updateId(id)
            }
        }
    }

    fun saveNew() {
        save()
        new()
    }

    fun getAll() = viagemDao.getAll()

}