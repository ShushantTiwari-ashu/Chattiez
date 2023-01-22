package com.shushant.common.compose.utils

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * A Class [Dimens] that has dimensions for different screen sizes.
 */

class Dimens(
    val carousel_card_padding: Dp,
    val gradientButtonHeight: Dp,
)

val sw320 = Dimens(
    carousel_card_padding = 45.0f.toLdpi(),
    gradientButtonHeight = 50.0f.toLdpi(),
)
val sw480 = Dimens(
    carousel_card_padding = 45.dp,
    gradientButtonHeight = 50.dp
)

val sw600 = Dimens(
    carousel_card_padding = 45.0f.toHdpi(),
    gradientButtonHeight = 50.0f.toHdpi(),
)

val sw720 = Dimens(
    carousel_card_padding = 45.0f.toXhdpi(),
    gradientButtonHeight = 50.0f.toXhdpi(),
)
