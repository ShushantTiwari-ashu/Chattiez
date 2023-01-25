package com.shushant.chattiez.splash.di

import com.shushant.chattiez.splash.filldetails.UserDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val onBoardingModule = module {
    viewModel { UserDetailsViewModel() }
}