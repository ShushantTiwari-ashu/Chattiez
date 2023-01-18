package com.shushant.chattiez.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shushant.chatiez.feature.auth.R
import com.shushant.chattiez.auth.common.BottomSection
import com.shushant.common.compose.theme.Typography
import com.shushant.common.compose.theme.textColor
import com.shushant.common.compose.ui.ChattiezClickableText
import com.shushant.common.compose.utils.toast
import com.shushant.navigation.AppComposeNavigator
import com.shushant.resource.ChatIcons

@Composable
fun LoginScreen(composeNavigator: AppComposeNavigator) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(top = 100.dp, start = 20.dp, end = 20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Image(
            painter = painterResource(id = ChatIcons.LOGO.drawable),
            contentDescription = stringResource(
                R.string.logo
            ), modifier = Modifier.size(96.dp)
        )

        Text(
            text = stringResource(R.string.log_in_to_make_your_memories),
            style = Typography.bodyLarge,
            color = textColor
        )

        LoginFields(onEmailChange = {

        }, onPasswordChange = {

        })

        ChattiezClickableText {
            context.toast(message = it)
        }

        BottomSection()
    }
}