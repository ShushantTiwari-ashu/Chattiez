package com.shushant.chattiez.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.shushant.chatiez.feature.auth.R
import com.shushant.common.compose.textFieldColors
import com.shushant.common.compose.theme.PRIMARY500
import com.shushant.common.compose.theme.Typography
import com.shushant.common.compose.theme.textColor
import com.shushant.common.compose.ui.GradientButton
import com.shushant.resource.ChatIcons
import com.shushant.resource.getPasswordToggle


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun LoginFields(onEmailChange: (String) -> Unit, onPasswordChange: (String) -> Unit) {
    var email: String by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = email,
        placeholder = {
            Text(
                text = "user@email.com",
                modifier = Modifier,
                textAlign = TextAlign.Center
            )
        },
        label = {
            Text(
                text = "Email or phone number",
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.None
            )
        },
        onValueChange = { email = it },
        textStyle = Typography.bodyLarge.copy(textAlign = TextAlign.Start),
        leadingIcon = {
            Image(
                painter = painterResource(id = ChatIcons.EMAIL.drawable),
                contentDescription = "Email", colorFilter = ColorFilter.tint(
                    textColor
                )
            )
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                // do something here
            }
        ),
        colors = textFieldColors,
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(), shape = RoundedCornerShape(10.dp)
    )

    OutlinedTextField(
        value = password,
        placeholder = { Text(text = "Password", textAlign = TextAlign.Center) },
        label = {
            Text(
                text = "Password",
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.None
            )
        },
        leadingIcon = {
            Image(
                painter = painterResource(id = ChatIcons.PASSWORD.drawable),
                contentDescription = "Email", colorFilter = ColorFilter.tint(
                    textColor
                )
            )
        },
        trailingIcon = {
            Image(
                painter = painterResource(id = passwordVisibility.getPasswordToggle().drawable),
                contentDescription = "password_toggle",
                modifier = Modifier.clickable { passwordVisibility = !passwordVisibility },
                colorFilter = ColorFilter.tint(
                    textColor
                )
            )
        },
        onValueChange = { password = it },
        textStyle = Typography.bodyLarge.copy(textAlign = TextAlign.Start),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(
            '*'
        ),
        colors = textFieldColors,
        singleLine = true,
    )
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.forgot),
            textAlign = TextAlign.End,
            style = Typography.bodyLarge,
            color = PRIMARY500,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .wrapContentSize()
                .clickable { }
        )
    }
    GradientButton(buttonText = stringResource(R.string.log_in)) {

    }
}