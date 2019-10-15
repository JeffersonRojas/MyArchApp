package com.github.jeffersonrojas.myarchapp.common.presentation.ktx

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

fun <T : ViewDataBinding> Fragment.dataBinding(@LayoutRes layoutResId: Int): Lazy<T> = object : Lazy<T> {

    private var cached: T? = null

    override val value: T
        get() = cached ?: DataBindingUtil.inflate<T>(
            layoutInflater,
            layoutResId,
            null,
            false
        ).apply {
            cached = this
            lifecycleOwner = viewLifecycleOwner.apply {
                lifecycle.addObserver(object : LifecycleObserver {
                    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                    fun onDestroyView() {
                        lifecycle.removeObserver(this)
                        cached = null
                    }
                })
            }
        }

    override fun isInitialized(): Boolean = cached != null
}
