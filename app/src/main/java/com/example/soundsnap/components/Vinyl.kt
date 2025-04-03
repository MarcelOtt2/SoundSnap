package com.example.a04_11_abschluss.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.a04_11_abschluss.R
import com.example.a04_11_abschluss.model.Track

@Composable
fun Vinyl(
    track: Track,
    modifier: Modifier = Modifier,
    rotation: Float = 0f,
    onSongDetailSelection: (Track) -> Unit
) {
    Box(
        modifier = modifier
            .aspectRatio(1.0f)
            .clip(
                RoundedCornerShape(10.dp)
            )
    )
    {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .rotate(rotation),
            painter = painterResource(id = R.drawable.vinyl_background),
            contentDescription = "Vinyl Background"
        )
        AsyncImage(
            model = track.imageUrl,
            contentDescription = "Track Image",
            modifier = Modifier
                .size(230.dp)
                .clip(CircleShape)
                .rotate(rotation)
                .aspectRatio(1.0f)
                .align(Alignment.Center)
                .clickable { onSongDetailSelection(track) },
        )
    }
}
