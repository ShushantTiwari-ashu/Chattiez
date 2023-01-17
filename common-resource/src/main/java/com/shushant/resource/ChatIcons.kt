package com.shushant.resource

import androidx.annotation.DrawableRes

enum class ChatIcons(@DrawableRes val drawable: Int) {
    LOGO(R.drawable.logo_mark),
    BG(R.drawable.bg_big),
    BG_ON_BOARDING1(R.drawable.bg_onboarding),
    BG_SVG(R.drawable.bg),
    ILLUSTRATION(R.drawable.illustration),
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
}
fun Boolean.getPasswordToggle() = if (this) ChatIcons.PASSWORD else ChatIcons.PASSWORD_TOGGLE
