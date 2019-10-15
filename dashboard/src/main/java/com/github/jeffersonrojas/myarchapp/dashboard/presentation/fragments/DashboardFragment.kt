package com.github.jeffersonrojas.myarchapp.dashboard.presentation.fragments

import androidx.fragment.app.viewModels
import com.github.jeffersonrojas.myarchapp.common.presentation.fragments.BaseFragment
import com.github.jeffersonrojas.myarchapp.dashboard.presentation.viewmodels.DashboardViewModel

class DashboardFragment : BaseFragment<DashboardViewModel>() {

    override val viewModel: DashboardViewModel by viewModels()
}
