package com.shushant.chattiez.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shushant.chatiez.feature.auth.R
import com.shushant.common.compose.theme.*
import com.shushant.common.compose.ui.ChattiezButton
import com.shushant.common.compose.ui.GradientButton
import com.shushant.navigation.AppComposeNavigator
import com.shushant.resource.ChatIcons

@Composable
fun AuthScreen(composeNavigator: AppComposeNavigator) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = ChatIcons.BG_ON_BOARDING1.drawable),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .padding(top = 164.dp)
        ) {
            Image(
                painter = painterResource(id = ChatIcons.ILLUSTRATION.drawable),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(282.dp)
            )

            Spacer(modifier = Modifier.height(44.dp))

            GradientButton(
                buttonText = stringResource(id = R.string.login_with_google),
                icon = ChatIcons.GOOGLE
            ) {

            }

            Spacer(modifier = Modifier.height(10.dp))

            ChattiezButton(buttonText = stringResource(id = R.string.sign_up_with)) {

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Divider(
                    color = buttonColor,
                    modifier = Modifier.weight(4f)
                )
                Text(
                    text = "OR",
                    style = Typography.bodyLarge,
                    color = textColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                Divider(
                    color = buttonColor,
                    modifier = Modifier.weight(4f)
                )
            }

        }

    }
}