package com.example.a04_11_abschluss.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.a04_11_abschluss.R
import com.example.a04_11_abschluss.components.AuthTextEditField

@Composable
fun RegisterScreen(
    onLoginSelection: () -> Unit,
    onRegisterSelection: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var valueEmail by rememberSaveable { mutableStateOf("") }
    var valuePassword by rememberSaveable { mutableStateOf("") }
    var valuePasswordConfirm by rememberSaveable { mutableStateOf("") }
    Box(
        Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.backgrounlogin),
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,

            )
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            content = {
                Spacer(Modifier.height(200.dp))
                Text(
                    text = "Register",
                    style = MaterialTheme.typography.headlineLarge,
                )
                AuthTextEditField(
                    value = valueEmail,
                    icon = Icons.Default.Email,
                    label = "Email",
                    onValueChange = { valueEmail = it }
                )
                AuthTextEditField(
                    value = valuePassword,
                    icon = Icons.Default.Lock,
                    label = "Password",
                    onValueChange = { valuePassword = it }
                )
                AuthTextEditField(
                    value = valuePasswordConfirm,
                    icon = Icons.Default.Lock,
                    label = "Password",
                    onValueChange = { valuePasswordConfirm = it }
                )
                Spacer(Modifier.height(24.dp))
                TextButton(
                    onClick = { onLoginSelection() },
                    content = {
                        Text("Schon einen Account ? Login hier ->")
                    }
                )
                Button(
                    enabled = valuePassword == valuePasswordConfirm && valuePassword.isNotEmpty() && valueEmail.isNotEmpty(),
                    onClick = {
                        onRegisterSelection(valueEmail, valuePassword)
                    },
                    content = { Text("Register") }
                )
            }
        )
    }
}