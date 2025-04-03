package com.example.a04_11_abschluss.components

import android.R.attr.contentDescription
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import com.example.a04_11_abschluss.model.Track
import com.example.a04_11_abschluss.navigation.PlayRoute


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun SearchItem(
    track: Track?,
    onTrackSelection: (Track) -> Unit
    ) {
Log.d("SearchItem", "Track: ${track?.trackName?: "Track is null"}")
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onTrackSelection(track!!) },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
               SubcomposeAsyncImage(
                    model = track?.imageUrl?:"",
                    contentDescription = "Track Image",
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Fit,
                    filterQuality = FilterQuality.High
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align (Alignment.CenterHorizontally),
                text = track?.trackName?:"",
                fontSize = 30.sp,
                style = MaterialTheme.typography.titleMedium)

            Text(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.CenterHorizontally),
                text = track?.artistName?:"",
                fontSize = 30.sp,
                style = MaterialTheme.typography.titleMedium)
        }
    }
}