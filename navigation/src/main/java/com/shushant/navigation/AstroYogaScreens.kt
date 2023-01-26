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

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class AstroYogaScreens(
    val route: String,
    val index: Int? = null,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    val name: String = route.appendArguments(navArguments)

    // login screen
    object Splash : AstroYogaScreens("splash")

    // onBoarding screen
    object OnBoarding : AstroYogaScreens("on_boarding")

    // onBoarding screen
    object TakeUserDetails : AstroYogaScreens("take_user_details")

    // auth screen
    object AuthFlow : AstroYogaScreens("auth_flow")

    // auth screen
    object Login : AstroYogaScreens("login")

    // sign up screen
    object SignUp : AstroYogaScreens("sign_up")

    // activated screen
    object AccountActivated : AstroYogaScreens("activated")

    // message screen
    object Messages : AstroYogaScreens(
        route = "messages",
        navArguments = listOf(navArgument(argument_channel_id) { type = NavType.StringType })
    ) {
        fun createRoute(channelId: String) =
            name.replace("{${navArguments.first().name}}", channelId)
    }

    companion object {
        const val argument_channel_id = "channelId"
    }
}

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
        .orEmpty()
    val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
        .orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}