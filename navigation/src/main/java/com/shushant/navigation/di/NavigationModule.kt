package com.shushant.navigation.di

import com.shushant.navigation.AppComposeNavigator
import com.shushant.navigation.ChattiezComposeNavigator
import com.shushant.navigation.NavigatorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val navigationModule = module {
    viewModel { NavigatorViewModel(get(), get()) }
    single<AppComposeNavigator> { ChattiezComposeNavigator() }
}