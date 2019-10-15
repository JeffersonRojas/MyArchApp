package com.github.jeffersonrojas.myarchapp.common.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.github.jeffersonrojas.myarchapp.common.presentation.ktx.showSnackbar
import com.github.jeffersonrojas.myarchapp.common.presentation.navigation.NavigationCommand
import com.github.jeffersonrojas.myarchapp.common.presentation.viewmodels.BaseViewModel
import com.uber.autodispose.android.lifecycle.autoDispose

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
        observeActions()
    }

    open fun observeActions() {
        viewModel.errorPublisher.autoDispose(this).subscribe(this::showError)
        viewModel.navigationPublisher.autoDispose(this).subscribe(this::navigate)
    }

    open fun showError(error: Exception) = showSnackbar(error)

    open fun navigate(navigationCommand: NavigationCommand) {
        when (navigationCommand) {
            is NavigationCommand.To -> navigate(navigationCommand.directions)
            is NavigationCommand.Back -> back()
        }
    }

    open fun back() {
        if (findNavController().popBackStack().not()) {
            activity?.finish()
        }
    }

    open fun navigate(navDirections: NavDirections) {
        findNavController().navigate(navDirections)
    }
}
