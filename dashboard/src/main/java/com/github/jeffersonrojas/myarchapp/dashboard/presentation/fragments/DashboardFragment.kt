package com.github.jeffersonrojas.myarchapp.dashboard.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.github.jeffersonrojas.myarchapp.common.presentation.fragments.BaseFragment
import com.github.jeffersonrojas.myarchapp.dashboard.presentation.viewmodels.DashboardViewModel

class DashboardFragment : BaseFragment<DashboardViewModel>() {

    override val viewModel: DashboardViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
