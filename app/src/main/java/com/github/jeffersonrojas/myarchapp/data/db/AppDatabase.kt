package com.github.jeffersonrojas.myarchapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.jeffersonrojas.myarchapp.dashboard.data.entities.ProductEntity
import com.github.jeffersonrojas.myarchapp.dashboard.data.repositories.ProductDao

@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
}
