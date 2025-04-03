package com.example.a04_11_abschluss.components

import android.R.attr.track
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a04_11_abschluss.model.Track

@Composable
fun InfoText(
    track: Track
) {
    Row {
        Text(
            "Titel:",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = track.trackName,
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 30.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
    Row {
        Text(
            "Artist:",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = track.artistName,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 30.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}