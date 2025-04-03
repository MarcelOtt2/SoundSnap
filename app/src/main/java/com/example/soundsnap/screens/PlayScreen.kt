package com.example.a04_11_abschluss.screens
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.a04_11_abschluss.components.AnimatedVinyl
import com.example.a04_11_abschluss.components.BackButton
import com.example.a04_11_abschluss.components.FavoriteButton
import com.example.a04_11_abschluss.components.InfoText
import com.example.a04_11_abschluss.components.SkipNextButton
import com.example.a04_11_abschluss.components.PlayButton
import com.example.a04_11_abschluss.components.AppBackground
import com.example.a04_11_abschluss.components.SkipPreviousButton
import com.example.a04_11_abschluss.model.Track
import com.example.a04_11_abschluss.viewmodel.TrackViewModel

@Composable
fun PlayScreen(
    song: Track?,
    track: Track,
    navigateBack: () -> Unit,
    onToggleFavorite: () -> Unit,
    isFavorite: Boolean,
    isPlaying: Boolean,
    onPlayPause: () -> Unit,
    viewModel: TrackViewModel = viewModel(),
    navHostController: NavHostController,
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AppBackground()
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            BackButton(
                modifier = Modifier
                    .align(Alignment.Start)
                    .clip(RoundedCornerShape(16.dp)),
                navigateBack = navigateBack
            )
        }
        Column(
            modifier = Modifier
                .padding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(80.dp))
                Box(
                    modifier = Modifier
                        .padding(vertical = 32.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .aspectRatio(1f)
                ) {
                    AnimatedVinyl(
                        isPlaying = isPlaying,
                        modifier = Modifier,
                        track = track,
                        navHostController = navHostController,
                    )
                }
                    InfoText(
                        track = track
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        SkipPreviousButton(
                            viewModel = viewModel,
                            song = song
                        )
                        PlayButton(
                            isPlaying = isPlaying,
                            onPlayPause = onPlayPause
                        )
                        SkipNextButton(
                            viewModel = viewModel,
                            song = song
                        )
                        FavoriteButton(
                            isFavorite = isFavorite,
                            onToggleFavorite = onToggleFavorite
                        )
                    }
                }
            }
        }