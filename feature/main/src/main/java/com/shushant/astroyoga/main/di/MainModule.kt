package com.shushant.astroyoga.main.di

import com.shushant.astroyoga.main.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel { HomeViewModel(get()) }
}