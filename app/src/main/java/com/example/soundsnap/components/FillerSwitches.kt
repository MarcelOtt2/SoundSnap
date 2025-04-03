package com.example.a04_11_abschluss.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.a04_11_abschluss.R

@Composable
fun FillerSwitches()
{
    var dailyMusic by remember { mutableStateOf(true) }
    var offlineMode by remember { mutableStateOf(false) }
    Text(
        "Benachrichtigungen",
        color = colorResource(id = R.color.black),
        style = MaterialTheme.typography.titleMedium
    )
    Switch(
        checked = dailyMusic,
        onCheckedChange = { dailyMusic = it },
        modifier = Modifier.padding(vertical = 8.dp),
        colors = SwitchDefaults.colors(
            checkedThumbColor = colorResource(id = R.color.teal_700),
            checkedTrackColor = colorResource(id = R.color.black),
            uncheckedThumbColor = colorResource(id = R.color.black),
            uncheckedTrackColor = colorResource(id = R.color.white)
        )
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        "Offline-Modus",
        color = colorResource(id = R.color.black),
    )
    Switch(
        checked = offlineMode,
        onCheckedChange = { offlineMode = it },
        modifier = Modifier.padding(vertical = 8.dp),
        colors = SwitchDefaults.colors(
            checkedThumbColor = colorResource(id = R.color.teal_700),
            checkedTrackColor = colorResource(id = R.color.black),
            uncheckedThumbColor = colorResource(id = R.color.black),
            uncheckedTrackColor = colorResource(id = R.color.white)
        )
    )
}