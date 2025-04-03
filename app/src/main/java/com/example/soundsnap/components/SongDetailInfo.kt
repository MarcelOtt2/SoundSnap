package com.example.a04_11_abschluss.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a04_11_abschluss.model.Track

@Composable
fun SongDetailInfo(
    track: Track
) {
        Row {
            Text(
                "Titel:",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = track.trackName,
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Row {
            Text(
                "Artist:",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = track.artistName,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Row() {
            Text(
                "Land:",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = track.country,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 24.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "Genre:",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = track.primaryGenreName,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 24.sp,
                color = Color.Black
            )
        }
        Row() {
            Text(
                "Datum:",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = track.releaseDate,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 24.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(
                "Weiter Songs von: ",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = track.artistName,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                fontSize = 24.sp
            )
        }
    }