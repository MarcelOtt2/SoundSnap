package com.example.a04_11_abschluss.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.a04_11_abschluss.R

enum class NavigationItem(
    val label: Int,
    val icon: ImageVector,
    val route: Any,
) {
    Play(
        label = R.string.play,
        icon = Icons.Default.PlayArrow,
        route = PlayRoute
    ),

    Favorite(
        label = R.string.favorite,
        icon = Icons.Default.Favorite,
        route = FavoritesListRoute
    ),

    Search(
        label = R.string.search,
        icon = Icons.Default.Search,
        route = SearchRoute
    ),

    Settings(
        label = R.string.settings,
        icon = Icons.Default.Settings,
        route = SettingsRoute
    ),


}