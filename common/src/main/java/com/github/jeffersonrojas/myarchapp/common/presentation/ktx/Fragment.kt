package com.github.jeffersonrojas.myarchapp.common.presentation.ktx

import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.github.jeffersonrojas.myarchapp.common.data.ktx.toUserError
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

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

fun Fragment.showSnackbar(text: String, @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_LONG) {
    val rootView = activity?.findViewById<View>(android.R.id.content) ?: return
    Snackbar.make(rootView, text, duration).show()
}

fun Fragment.showSnackbar(error: Exception, @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_LONG) {
    showSnackbar(error.toUserError(activity ?: return), duration)
}
