package com.example.a04_11_abschluss.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.a04_11_abschluss.screens.SongDetailScreen
import com.example.a04_11_abschluss.screens.FavoriteScreen
import com.example.a04_11_abschluss.screens.LoginScreen
import com.example.a04_11_abschluss.screens.PlayScreen
import com.example.a04_11_abschluss.screens.RegisterScreen
import com.example.a04_11_abschluss.screens.SettingScreen
import com.example.a04_11_abschluss.viewmodel.TrackViewModel
import com.example.a04_11_abschluss.viewmodel.AuthViewModel
import com.example.soundsnap.screens.SearchScreen
import kotlin.collections.map


@Composable
fun AppNavHost(
    isDarkMode: Boolean = false,
    onChange: (Boolean) -> Unit,
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: TrackViewModel,
    authViewModel: AuthViewModel

) {
    val tracks by viewModel.tracks.collectAsState()
    val favorites by authViewModel.favoriteTrackList.collectAsState()
    val selectedTrack by viewModel.selectedTrack.collectAsState()
    val isPlaying by viewModel.isPlaying.collectAsState()
    val firebaseViewModel: AuthViewModel = viewModel()
    val currentUser by firebaseViewModel.currentUser.collectAsState()

    NavHost(

        navController = navHostController,
        startDestination = LoginRoute,
    ) {

        composable<LoginRoute> {
            LoginScreen(
                onLoginSelection = { email, password ->
                    firebaseViewModel.login(email, password)
                },
                onRegisterSelection = {
                    navHostController.navigate(RegisterRoute)
                },
                modifier = modifier
            )
            if (currentUser != null) {
                navHostController.navigate(PlayRoute) {
                    popUpTo<PlayRoute>()
                    launchSingleTop = true
                }
            }
        }
        composable<RegisterRoute> {
            RegisterScreen(
                onLoginSelection = {
                    navHostController.navigate(LoginRoute)
                },
                onRegisterSelection = { email, password ->
                    firebaseViewModel.register(email, password)
                },
                modifier = modifier
            )
            if (currentUser != null) {
                navHostController.navigate(PlayRoute) {
                    popUpTo<PlayRoute>()
                    launchSingleTop = true
                }
            }
        }
        composable<PlayRoute> {
            val listOfTrackIds: List<String> = favorites.map { it.trackId }
            val isFavorite = listOfTrackIds.contains(selectedTrack?.trackId)
            LaunchedEffect(selectedTrack) {
                viewModel.selectTrack(selectedTrack ?: tracks[0])
            }
            PlayScreen(
                track = selectedTrack ?: tracks[0],
                navigateBack = { navHostController.popBackStack() },
                isFavorite = isFavorite,
                onToggleFavorite = {
                    if (currentUser != null) {
                        if (isFavorite) {
                            firebaseViewModel.removeTrackFromFavoriteList(selectedTrack)
                        } else {
                            firebaseViewModel.addTrackToFavoriteList(selectedTrack)
                        }
                    } else {
                        navHostController.navigate(LoginRoute)
                    }
                },
                isPlaying = isPlaying,
                onPlayPause = { viewModel.togglePlayPause() },
                song = selectedTrack,
                viewModel = viewModel,
                navHostController = navHostController,
            )
        }

        composable<FavoritesListRoute> {
            Log.d("FIRE", "favoriteTracks $favorites")
            FavoriteScreen(
                favorites = favorites,
                navHostController = navHostController,
                viewModel = viewModel
            )
        }
        composable<SearchRoute> {

            SearchScreen(

                viewModel = viewModel,
                navHostController = navHostController,
                )
        }
        composable<SettingsRoute> {
            SettingScreen(
                onLogoutSelection = {
                    firebaseViewModel.logout()
                    navHostController.navigate(LoginRoute)
                },
                isDarkMode = isDarkMode,
                onChange = onChange,
                )
        }
        composable<SongDetailRoute> {

            SongDetailScreen(
                navigateBack = { navHostController.popBackStack() },
                track = selectedTrack ?: tracks[0] ,
                viewModel = viewModel,
                navHostController = navHostController,
            )
        }
    }
}