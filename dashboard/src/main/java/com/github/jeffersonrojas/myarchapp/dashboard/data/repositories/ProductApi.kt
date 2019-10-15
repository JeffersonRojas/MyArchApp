package com.github.jeffersonrojas.myarchapp.dashboard.data.repositories

import com.github.jeffersonrojas.myarchapp.dashboard.data.entities.ProductEntity
import io.reactivex.Single
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    fun getAll(): Single<List<ProductEntity>>
}
