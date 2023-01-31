package com.shushant.astroyoga.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.shushant.navigation.destinations.BottomNavItem
import com.shushant.common.compose.theme.NAME_COLOR
import com.shushant.common.compose.theme.Typography

@Composable
fun AstroBottomBar(
    destinations: List<BottomNavItem>,
    navigate: (BottomNavItem) -> Unit,
    currentDestination: NavDestination?
) {

    val bottomBarDestination = destinations.any { it.screen_route == currentDestination?.route }

    if (bottomBarDestination) {
        NavigationBar(
            containerColor = Color.White,
            contentColor = NAME_COLOR,
            modifier = Modifier
                .safeDrawingPadding()
                .height(76.dp)
                .padding(start = 16.dp, end = 16.dp, bottom = 10.dp, top = 10.dp)
                .background(shape = RoundedCornerShape(10.dp), color = Color.White)
        ) {
            destinations.forEach { item ->
                BottomNavigationItem(icon = {
                    Icon(
                        painterResource(id = item.icon), contentDescription = item.title
                    )
                },
                    label = {
                        Text(
                            text = item.title, fontSize = 9.sp, style = Typography.bodyLarge
                        )
                    },
                    selectedContentColor = NAME_COLOR,
                    unselectedContentColor = Color.Black.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = currentDestination?.hierarchy?.any {
                        it.route == item.screen_route
                    } == true,
                    onClick = {
                        navigate.invoke(item)
                    })
            }
        }
    }
}