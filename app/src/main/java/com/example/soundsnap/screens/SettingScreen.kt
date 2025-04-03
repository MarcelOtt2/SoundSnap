package com.example.a04_11_abschluss.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.a04_11_abschluss.R
import com.example.a04_11_abschluss.components.AppBackground
import com.example.a04_11_abschluss.components.FillerSwitches
import com.example.a04_11_abschluss.components.LogoutButton
import com.example.a04_11_abschluss.components.SettingsInfo
import com.example.a04_11_abschluss.components.SwitchDunkelModus

@Composable
fun SettingScreen(
    onLogoutSelection: () -> Unit,
    isDarkMode: Boolean,
    onChange: (Boolean) -> Unit,
) {
    Box(
        Modifier.fillMaxSize()
    ) {
        AppBackground()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Einstellungen",
                color = colorResource(id = R.color.black),
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(5.dp))
            LogoutButton(
                onLogoutSelection = onLogoutSelection
            )
            SwitchDunkelModus(
                isDarkMode = isDarkMode,
                onChange = onChange
            )
            Spacer(modifier = Modifier.height(16.dp))
            FillerSwitches()
            Spacer(modifier = Modifier.height(30.dp))
            SettingsInfo()
        }
    }
}