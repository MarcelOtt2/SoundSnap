package com.example.a04_11_abschluss.components

import android.R.attr.text
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.a04_11_abschluss.model.Track
import com.example.a04_11_abschluss.navigation.PlayRoute
import com.example.a04_11_abschluss.viewmodel.AuthViewModel
import com.example.a04_11_abschluss.viewmodel.TrackViewModel
import kotlin.collections.contains

@Composable
fun FavoriteTrackList(
    favoriteTracks: List<Track>,
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: TrackViewModel = viewModel(),
) {
    val firebaseViewModel: AuthViewModel = viewModel()
    Column() {
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 10.dp)
                .align(Alignment.Start),
            text = "Favoriten",
            fontSize = 30.sp,
            )
        LazyColumn(
            modifier = modifier
        ) {
            items(favoriteTracks) { favoriteTrack ->
                FavoriteItemCard(
                    favoriteTrack = favoriteTrack,
                    onItemSelection = {
                        viewModel.selectTrack(favoriteTrack)
                        navHostController.navigate(PlayRoute)
                    },
                    onToggleFavorite = {
                        firebaseViewModel.removeTrackFromFavoriteList(favoriteTrack)
                    },
                )
            }
        }
    }
}
