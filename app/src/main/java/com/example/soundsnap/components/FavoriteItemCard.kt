package com.example.a04_11_abschluss.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.a04_11_abschluss.model.Track

@Composable
fun FavoriteItemCard(
    favoriteTrack: Track,
    onItemSelection: (Track) -> Unit,
    onToggleFavorite: () -> Unit,
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                    onItemSelection(favoriteTrack)
                }
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        model = favoriteTrack.imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        filterQuality = FilterQuality.High,
                    )
                    IconButton(
                        onClick =
                            onToggleFavorite
                    )
                    {
                        Icon(
                            modifier = Modifier.size(48.dp),
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Favorite",
                            tint = Color.Black
                        )
                    }
                }
                Text(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.CenterHorizontally),
                    text = favoriteTrack.trackName,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.CenterHorizontally),
                    text = favoriteTrack.artistName,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.headlineSmall,
                )
            }
        }
    }