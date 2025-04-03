package com.example.a04_11_abschluss.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a04_11_abschluss.model.Track
import com.example.a04_11_abschluss.viewmodel.TrackViewModel

@Composable
fun SkipNextButton(
    viewModel: TrackViewModel = viewModel(),
    song: Track?
)
{
    IconButton(
        onClick = {
            viewModel.nextTrack(song)
        },
        modifier = Modifier.size(64.dp)

    ) {
        Icon(
            imageVector = Icons.Default.SkipNext,
            contentDescription = "Rewind 10 seconds",
            modifier = Modifier.size(48.dp),
            tint = MaterialTheme.colorScheme.primary
        )
    }
}