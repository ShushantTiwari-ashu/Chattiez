package com.shushant.chattiez.auth.signup

import com.shushant.chattiez.data.base.State

data class RegisterState(
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false,
    val username: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isValidUsername: Boolean? = null,
    val isValidPassword: Boolean? = null,
    val isValidConfirmPassword: Boolean? = null,
    val error: String? = null
) : State