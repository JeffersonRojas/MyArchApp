package com.github.jeffersonrojas.myarchapp.common.presentation.viewmodels

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.github.jeffersonrojas.myarchapp.common.presentation.ktx.toCommand
import com.github.jeffersonrojas.myarchapp.common.presentation.navigation.NavigationCommand
import io.reactivex.subjects.PublishSubject
import org.koin.core.KoinComponent

abstract class BaseViewModel : ViewModel(), LifecycleOwner, LifecycleObserver, KoinComponent {

    private val lifecycleRegistry: LifecycleRegistry by lazy { LifecycleRegistry(this) }

    init {
        lifecycleRegistry.currentState = Lifecycle.State.CREATED
    }

    val navigationPublisher: PublishSubject<NavigationCommand> = PublishSubject.create()

    val errorPublisher: PublishSubject<Exception> = PublishSubject.create()

    override fun getLifecycle(): Lifecycle = lifecycleRegistry

    override fun onCleared() {
        super.onCleared()
        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }

    open fun navigateTo(navDirections: NavDirections) {
        navigationPublisher.onNext(navDirections.toCommand())
    }

    open fun navigateBack() {
        navigationPublisher.onNext(NavigationCommand.Back)
    }
}
