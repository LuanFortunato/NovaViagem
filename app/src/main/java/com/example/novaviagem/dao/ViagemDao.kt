package com.example.novaviagem.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.novaviagem.model.Viagem
import kotlinx.coroutines.flow.Flow

@Dao
interface ViagemDao {
    @Insert
    fun insert(viagem: Viagem): Long

    @Update
    fun update(viagem: Viagem)

    @Upsert
    suspend fun upsert(viagem: Viagem): Long

    @Query("select * from viagem v order by v.destino")
    fun getAll(): Flow<List<Viagem>>

    @Query("select * from viagem v where v.id = :id")
    fun findById(id: Long) : Viagem?

    @Delete
    fun delete(viagem: Viagem)
}