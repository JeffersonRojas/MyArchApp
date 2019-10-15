package com.github.jeffersonrojas.myarchapp.presentation.viewmodels

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.github.jeffersonrojas.myarchapp.common.presentation.viewmodels.BaseViewModel
import com.github.jeffersonrojas.myarchapp.presentation.fragments.SplashFragmentDirections

class SplashViewModel : BaseViewModel() {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        navigateTo(SplashFragmentDirections.actionToDashboard())
    }
}
