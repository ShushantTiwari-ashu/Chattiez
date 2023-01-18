package com.shushant.common.compose.ui.carousel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.shushant.common.compose.theme.Dimens
import com.shushant.common.compose.utils.gradientBackground
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlin.math.absoluteValue

const val protonCarouselView = "protonCarouselView"

/**
 * A layout composable that has [HorizontalPager] with carousel animation
 * @property modifier Composable that accept a [Modifier] as a parameter to be applied to the whole component
 * @property onPageChange callback to get the pageChange
 * @property pageSize number of pages
 * @property selectedPage setCurrentItem of the pager
 * @property content the children composable to be laid out.
 */
@Composable
fun ChattiezCarouselView(
    modifier: Modifier,
    onPageChange: (Int) -> Unit,
    pageSize: Int,
    selectedPage: Int?,
    gradientColors: List<Color>,
    updateTransition: () -> Unit,
    content: @Composable (page: Int) -> Unit,
) {
    val pagerState = rememberPagerState(initialPage = selectedPage ?: 0)
    LaunchedEffect(key1 = pagerState) {
        // Collect from the pager state a snapshotFlow reading the currentPage
        snapshotFlow { pagerState.currentPage }.distinctUntilChanged().collect { page ->
            updateTransition.invoke()
            delay(50)
            onPageChange.invoke(page)
        }
    }

    HorizontalPager(
        count = pageSize,
        contentPadding = PaddingValues(
            horizontal = Dimens.carousel_card_padding,
        ),
        modifier = modifier.semantics { this.contentDescription = protonCarouselView },
        state = pagerState,
    ) { page ->
        Card(
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page = page).absoluteValue

                    lerp(
                        start = 0.85f,
                        stop = 1.0f,
                        fraction = 1.0f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }

                    alpha = lerp(
                        start = 0.2f,
                        stop = 1.0f,
                        fraction = 1.0f - pageOffset.coerceIn(0f, 1f)
                    )
                }
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .gradientBackground(
                        colors = gradientColors,
                        angle = 201.22f
                    )
                    .fillMaxSize()
            ) {
                content(page)
            }
        }
    }
}

/**
 * Linearly interpolate between [start] and [stop] with [fraction] fraction between them.
 */
fun lerp(start: Float, stop: Float, fraction: Float) = (1 - fraction) * start + fraction * stop
