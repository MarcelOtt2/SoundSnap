package com.example.a04_11_abschluss.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.a04_11_abschluss.R

@Composable
fun SettingsInfo(){
    Text(
        "Über",
        color = colorResource(id = R.color.black),
        style = MaterialTheme.typography.titleMedium
    )
    Text(
        "App-Version: 1.0.0",
        color = colorResource(id = R.color.black),
    )
    Text(
        "Entwickler: [Marcel Ott]",
        color = colorResource(id = R.color.black),
    )
}