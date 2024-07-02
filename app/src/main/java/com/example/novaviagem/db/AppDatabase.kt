package com.example.novaviagem.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.novaviagem.dao.UserDao
import com.example.novaviagem.dao.ViagemDao
import com.example.novaviagem.model.User
import com.example.novaviagem.model.Viagem
import com.example.novaviagem.utils.Converters


@TypeConverters(Converters::class)
@Database(entities = [User::class, Viagem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao
    abstract val viagemDao: ViagemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase = INSTANCE ?: synchronized(this){
            val instance = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "viagem-db"
            ).build()
            INSTANCE = instance
            instance
        }
    }

}