package com.example.a04_11_abschluss.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.SubcomposeAsyncImage
import com.example.a04_11_abschluss.components.BackButton
import com.example.a04_11_abschluss.components.AppBackground
import com.example.a04_11_abschluss.components.SongDetailInfo
import com.example.a04_11_abschluss.components.SongItem
import com.example.a04_11_abschluss.model.Track
import com.example.a04_11_abschluss.navigation.PlayRoute
import com.example.a04_11_abschluss.viewmodel.TrackViewModel

@Composable
fun SongDetailScreen(
    track: Track,
    navigateBack: () -> Unit,
    viewModel: TrackViewModel,
    navHostController: NavHostController
) {
    val tracks = viewModel.tracks.collectAsState()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
    AppBackground()
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp),
        ) {
            BackButton(
                modifier = Modifier
                    .align(Alignment.Start)
                    .clip(RoundedCornerShape(16.dp)),
                navigateBack = navigateBack
            )
        }
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
                Spacer(modifier = Modifier.height(80.dp))
                SubcomposeAsyncImage(
                    modifier = Modifier
                        .size(300.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    model = track.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    filterQuality = FilterQuality.High,
                )
                    SongDetailInfo(
                        track
                    )
                Spacer(modifier = Modifier.height(8.dp))
                LazyColumn {
                    items(tracks.value) { track ->
                        SongItem(
                            track,
                            onTrackSelection = {
                                viewModel.selectTrack(track)
                                navHostController.navigate(PlayRoute)}
                        )
                    }
                }
            }
        }
    }