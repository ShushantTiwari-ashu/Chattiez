package com.shushant.chattiez.splash.filldetails

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.shushant.common.compose.ui.carousel.CarouselView
import com.shushant.navigation.AppComposeNavigator
import com.skydoves.whatif.whatIfNotNullOrEmpty
import org.koin.androidx.compose.getViewModel

@Composable
fun GetDetailsCarousel(
    composeNavigator: AppComposeNavigator, viewModel: UserDetailsViewModel = getViewModel()
) {
    val selectedIndex by viewModel.selectedIndex.collectAsStateWithLifecycle()
    val composable by viewModel.composableScreens.collectAsStateWithLifecycle()
    val userState by viewModel.state.collectAsStateWithLifecycle()
    val list = mutableListOf<@Composable (() -> Unit)>().apply {
        repeat(8) {
            add { UserNameItem(viewModel::setUserName, userState) }
        }
    }
    LaunchedEffect(key1 = Unit) {
        viewModel.addComposables(list)
    }

    composable.whatIfNotNullOrEmpty {
        CarouselView(
            onPageChange = {
                viewModel.setSelectedIndex(it)
            },
            pageSize = list.count(),
            selectedPage = selectedIndex,
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) { page: Int ->
            val data = it[page].action
            if (data != null) {
                data()
            }
        }
    }
}