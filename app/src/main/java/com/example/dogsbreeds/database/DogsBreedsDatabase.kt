package com.example.dogsbreeds.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dogsbreeds.dao.UserDao
import com.example.dogsbreeds.models.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class DogsBreedsDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var Instance: DogsBreedsDatabase? = null
        fun getDatabase(context: Context): DogsBreedsDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, DogsBreedsDatabase::class.java, "DogsBreedsDatabase")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}