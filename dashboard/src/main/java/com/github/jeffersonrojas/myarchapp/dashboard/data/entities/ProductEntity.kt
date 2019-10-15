package com.github.jeffersonrojas.myarchapp.dashboard.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class ProductEntity(
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString(),
    @ColumnInfo
    val name: String = "",
    @ColumnInfo
    val description: String = "",
    @ColumnInfo
    val value: Long = 0
)
