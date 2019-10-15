package com.github.jeffersonrojas.myarchapp.common.presentation.ktx

import androidx.navigation.NavDirections
import com.github.jeffersonrojas.myarchapp.common.presentation.navigation.NavigationCommand

fun NavDirections.toCommand() = NavigationCommand.To(this)
