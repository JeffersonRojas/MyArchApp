package com.github.jeffersonrojas.myarchapp.dashboard.domain.usecases

import android.util.Log
import com.github.jeffersonrojas.myarchapp.common.data.ktx.injectApi
import com.github.jeffersonrojas.myarchapp.dashboard.data.repositories.ProductApi
import com.github.jeffersonrojas.myarchapp.dashboard.data.repositories.ProductDao
import org.koin.core.KoinComponent
import org.koin.core.inject

class ProductsUseCase : KoinComponent {

    private val productApi: ProductApi by injectApi()

    private val productDao: ProductDao by inject()

    fun getAll() = productApi.getAll().flatMap {
        productDao.insertAll(*it.toTypedArray()).doOnError {
            Log.e("ProductsUseCase", "error to save products", it)
        }.toSingle {
            it
        }
    }.onErrorResumeNext {
        productDao.getAll()
    }
}
