package com.example.a04_11_abschluss.components

import android.R.attr.contentDescription
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.SubcomposeAsyncImage
import com.example.a04_11_abschluss.R
import com.example.a04_11_abschluss.model.Track
import com.example.a04_11_abschluss.navigation.PlayRoute
import com.example.a04_11_abschluss.viewmodel.TrackViewModel

@Composable
fun SongItem(
    track: Track,
    onTrackSelection: (Track) -> Unit,


) {
    ElevatedCard(
        modifier = Modifier
            .height(80.dp)
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable {
                onTrackSelection(track)

            }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier.weight(1f),
                model = track.imageUrl,
                contentDescription = "Track Image",
                contentScale = ContentScale.Fit,
                error = {
                    AsyncImage(
                        model = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "Error"
                    )
                }
            )
            Column(
                modifier = Modifier.weight(4f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                val modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                Text(
                    modifier = modifier,
                    text = track.trackName,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    modifier = modifier,
                    text = track.artistName,
                    style = MaterialTheme.typography.bodySmall,

                )
            }
        }
    }
}