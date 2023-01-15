package com.shushant.resource

import androidx.annotation.DrawableRes

enum class ChatIcons(@DrawableRes val drawable: Int) {
    LOGO(R.drawable.logo_mark),
    BG(R.drawable.bg_big),
    BG_SVG(R.drawable.bg)
}