package com.example.novaviagem.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.novaviagem.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    fun insert(user: User): Long

    @Update
    fun update(user: User)

    @Upsert
    suspend fun upsert(user: User): Long

    @Query("select * from user u order by u.username")
    fun getAll(): Flow<List<User>>

    @Query("select * from user u where u.email = :email and u.password = :password")
    suspend fun login(email: String, password: String) : User?

    @Query("select * from user u where u.id = :id")
    fun findById(id: Long) : User?

    @Delete
    fun delete(user: User)
}