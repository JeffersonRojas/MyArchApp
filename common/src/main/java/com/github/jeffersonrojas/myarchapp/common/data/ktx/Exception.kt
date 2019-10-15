package com.github.jeffersonrojas.myarchapp.common.data.ktx

import android.content.Context
import com.github.jeffersonrojas.myarchapp.common.R
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import org.koin.core.context.GlobalContext

fun Exception.toUserError(context: Context = GlobalContext.get().koin.get()) = when (this) {
    is SocketTimeoutException -> context.getString(R.string.error_timeout)
    is UnknownHostException -> context.getString(R.string.error_internet)
    else -> message ?: context.getString(R.string.error_unknown)
}
