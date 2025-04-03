package com.example.a04_11_abschluss.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.a04_11_abschluss.R

@Composable
fun LogoutButton(
    onLogoutSelection: () -> Unit
){
    Button(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(16.dp),
        colors = buttonColors(
            containerColor = colorResource(id = R.color.teal_700),
            contentColor = colorResource(id = R.color.black)
        ),
        onClick = onLogoutSelection,
        content = {
            Text("Logout",
                style = MaterialTheme.typography.titleLarge
            )
        }
    )
}