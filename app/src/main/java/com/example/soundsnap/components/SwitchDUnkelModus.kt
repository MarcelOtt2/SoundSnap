package com.example.a04_11_abschluss.components

import android.widget.Switch
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.a04_11_abschluss.R

@Composable
fun SwitchDunkelModus(
    isDarkMode: Boolean,
    onChange: (Boolean) -> Unit
){
    Text(
        "Dunkelmodus",
        color = colorResource(id = R.color.black),
    )
    Switch(
        checked = isDarkMode,
        onCheckedChange = { onChange(isDarkMode) },
        colors = SwitchDefaults.colors(
            checkedThumbColor = colorResource(id = R.color.teal_700),
            checkedTrackColor = colorResource(id = R.color.black),
            uncheckedThumbColor = colorResource(id = R.color.black),
            uncheckedTrackColor = colorResource(id = R.color.white)
        )
    )
}
