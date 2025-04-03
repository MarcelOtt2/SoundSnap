package com.example.a04_11_abschluss.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.a04_11_abschluss.components.AppBackground
import com.example.a04_11_abschluss.components.FavoriteTrackList
import com.example.a04_11_abschluss.model.Track
import com.example.a04_11_abschluss.viewmodel.AuthViewModel
import com.example.a04_11_abschluss.viewmodel.TrackViewModel

@Composable
fun FavoriteScreen(
    favorites: List<Track>,
    navHostController: NavHostController,
    viewModel: TrackViewModel = viewModel(),
    authViewModel: AuthViewModel = viewModel()
) {
    val favoriteTracks = authViewModel.favoriteTrackList.collectAsState()

    Box(
    ) {
   AppBackground()
        FavoriteTrackList(
            favoriteTracks = favoriteTracks.value,
            modifier = Modifier.padding(),
            navHostController = navHostController,
            viewModel = viewModel,
        )
    }
}