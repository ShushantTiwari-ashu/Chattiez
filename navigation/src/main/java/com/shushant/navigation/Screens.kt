/*
 * Copyright (c) 2023 Shushant Tiwari.
 *
 * Licensed under the GNU General Public License v3
 *
 * This is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 */

package com.shushant.navigation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.*
import com.google.accompanist.navigation.animation.composable
import java.util.*

interface Screen {
    val route: String
}

val TAB_ROOT_SCREENS = listOf(
    TabRootScreen.HomeTab,
)

sealed class TabRootScreen(
    override val route: String,
    val startScreen: LeafScreen,
    val arguments: List<NamedNavArgument> = emptyList(),
    val deepLinks: List<NavDeepLink> = emptyList(),
) : Screen {
    object HomeTab : TabRootScreen("home_tab", LeafScreen.HomeTab())
}

sealed class LeafScreen(
    override val route: String,
    open val root: TabRootScreen? = null,
    protected open val path: String = "",
    val arguments: List<NamedNavArgument> = emptyList(),
    val deepLinks: List<NavDeepLink> = emptyList(),
) : Screen {


    fun createRoute(root: TabRootScreen? = null) =
        when (val rootPath = (root ?: this.root)?.route) {
            is String -> "$rootPath/$route"
            else -> route
        }

    data class HomeTab(override val route: String = "home_tab") :
        LeafScreen(route, TabRootScreen.HomeTab)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.composableScreen(
    screen: LeafScreen,
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route = screen.createRoute(),
        arguments = screen.arguments,
        deepLinks = screen.deepLinks,
        content = content
    )
}

@Composable
inline fun <reified VM : ViewModel> NavBackStackEntry.scopedViewModel(navController: NavController): VM {
    val parentId = destination.parent!!.id
    val parentBackStackEntry = navController.getBackStackEntry(parentId)
    return hiltViewModel(parentBackStackEntry)
}
