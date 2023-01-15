package com.shushant.resource

import androidx.annotation.DrawableRes

enum class ChatIcons(@DrawableRes val drawable: Int) {
    LOGO(R.drawable.logo_mark),
    BG(R.drawable.bg_big),
    BG_ON_BOARDING1(R.drawable.bg_onboarding),
    BG_SVG(R.drawable.bg),
    ILLUSTRATION(R.drawable.illustration),
    GOOGLE(R.drawable.google),
    ILLUSTRATION_1(R.drawable.illustration1),
    ILLUSTRATION_1_NIGHT(R.drawable.illustration1_night),
    PAGINATION_1(R.drawable.pagination_1),
    PAGINATION_2(R.drawable.pagination_2),
    GRADIENT_BG(R.drawable.gradient_text),
}

val Boolean.getIllustration: ChatIcons
    get() = if (this) ChatIcons.ILLUSTRATION_1_NIGHT else ChatIcons.ILLUSTRATION_1