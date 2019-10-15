package com.github.jeffersonrojas.myarchapp.data.di

import androidx.room.Room
import com.github.jeffersonrojas.myarchapp.data.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "app-db"
        ).build()
    }
    single {
        get<AppDatabase>().productDao()
    }
}
