package com.github.jeffersonrojas.myarchapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.github.jeffersonrojas.myarchapp.R
import com.github.jeffersonrojas.myarchapp.common.presentation.fragments.BaseFragment
import com.github.jeffersonrojas.myarchapp.common.presentation.ktx.dataBinding
import com.github.jeffersonrojas.myarchapp.databinding.FragmentSplashBinding
import com.github.jeffersonrojas.myarchapp.presentation.viewmodels.SplashViewModel

class SplashFragment : BaseFragment<SplashViewModel>() {

    override val viewModel: SplashViewModel by viewModels()

    private val binding: FragmentSplashBinding by dataBinding(R.layout.fragment_splash)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding.viewModel = viewModel
        return binding.root
    }
}
