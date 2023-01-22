package com.shushant.chattiez.auth.di

import com.shushant.chattiez.auth.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    viewModel { LoginViewModel(get()) }
}