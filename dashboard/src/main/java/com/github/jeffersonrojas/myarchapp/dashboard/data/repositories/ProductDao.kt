package com.github.jeffersonrojas.myarchapp.dashboard.data.repositories

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.github.jeffersonrojas.myarchapp.dashboard.data.entities.ProductEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface ProductDao {

    @Query("SELECT * FROM ProductEntity")
    fun getAll(): Single<List<ProductEntity>>

    @Query("SELECT * FROM ProductEntity WHERE uid IN (:productIds)")
    fun loadAllByIds(productIds: IntArray): Flowable<List<ProductEntity>>

    @Query("SELECT * FROM ProductEntity WHERE name LIKE :name LIMIT :limit")
    fun findByName(name: String, limit: Int = 1): Single<ProductEntity>

    @Insert
    fun insertAll(vararg users: ProductEntity): Completable

    @Delete
    fun delete(user: ProductEntity): Completable
}
