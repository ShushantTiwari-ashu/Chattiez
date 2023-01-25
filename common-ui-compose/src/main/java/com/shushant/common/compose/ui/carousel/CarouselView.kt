package com.shushant.common.compose.ui.carousel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged

const val protonCarouselView = "carouselView"

/**
 * A layout composable that has [HorizontalPager] with carousel animation
 * @property modifier Composable that accept a [Modifier] as a parameter to be applied to the whole component
 * @property onPageChange callback to get the pageChange
 * @property pageSize number of pages
 * @property selectedPage setCurrentItem of the pager
 * @property content the children composable to be laid out.
 */
@Composable
fun CarouselView(
    modifier: Modifier,
    onPageChange: (Int) -> Unit,
    pageSize: Int,
    selectedPage: Int?,
    content: @Composable (page: Int) -> Unit,
) {
    val pagerState = rememberPagerState(initialPage = selectedPage ?: 0)
    LaunchedEffect(key1 = pagerState) {
        // Collect from the pager state a snapshotFlow reading the currentPage
        snapshotFlow { pagerState.currentPage }.distinctUntilChanged().collect { page ->
            delay(50)
            onPageChange.invoke(page)
        }
    }

    Box(modifier = modifier) {
        HorizontalPager(
            count = pageSize,
            contentPadding = PaddingValues(
                horizontal = 0.dp, vertical = 0.dp,
            ),
            modifier = modifier.semantics { this.contentDescription = protonCarouselView },
            state = pagerState,
        ) { page ->
            content(page)
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp),
        )
    }
}
