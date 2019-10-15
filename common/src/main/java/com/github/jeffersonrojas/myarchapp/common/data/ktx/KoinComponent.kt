package com.github.jeffersonrojas.myarchapp.common.data.ktx

import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import retrofit2.Retrofit
import retrofit2.create

inline fun <reified T> KoinComponent.injectApi(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null
): Lazy<T> = lazy {
    getApi<T>(qualifier, parameters)
}

inline fun <reified T> KoinComponent.getApi(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null
): T = get<Retrofit>(qualifier, parameters).create()

inline fun <reified T> KoinComponent.injectOrCreate(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null
): Lazy<T> = lazy {
    getOrCreate<T>(qualifier, parameters)
}

inline fun <reified T> KoinComponent.getOrCreate(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null
): T = try {
    get(qualifier, parameters)
} catch (e: Exception) {
    T::class.java.newInstance()
}
