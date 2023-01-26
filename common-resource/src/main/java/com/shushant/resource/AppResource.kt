package com.shushant.resource

import androidx.annotation.DrawableRes

enum class AppResource(@DrawableRes val drawable: Int) {
    LOGO(R.drawable.logo_mark),
    ASTRO_LOGO(R.drawable.logo_astro_yoga),
    BG(R.drawable.bg_big),
    ASTRO_BACKGROUND(R.drawable.astro_background),
    BG_ON_BOARDING1(R.drawable.bg_onboarding),
    ASTRO_ON_BOARDING(R.drawable.onboarding),
    BG_SVG(R.drawable.bg),
    ILLUSTRATION(R.drawable.illustration),
    ASTRO_ILLUSTRATION(R.drawable.astro_illustration),
    GOOGLE(R.drawable.google),
    APPLE(R.drawable.apple),
    GITHUB(R.drawable.github),
    FACEBOOK(R.drawable.facebook),
    USERNAME(R.drawable.username),
    EMAIL(R.drawable.email),
    PASSWORD(R.drawable.password),
    PASSWORD_TOGGLE(R.drawable.password_toggle),
    PASSWORD_TOGGLE_OFF(R.drawable.baseline_visibility_off_24),
    GOOGLE_COLOURED(R.drawable.google_colored),
    PAGINATION_1(R.drawable.pagination_1),
    PAGINATION_2(R.drawable.pagination_2),
    GRADIENT_BG(R.drawable.gradient_text),
    ACTIVATED(R.drawable.activated_day),
    ACTIVATED_NIGHT(R.drawable.activated_night),
    TELL_YOUR_NAME(R.drawable.user_name),
    UNKNOWN(0)
}

fun Boolean.getPasswordToggle() = if (this) AppResource.PASSWORD else AppResource.PASSWORD_TOGGLE
