package com.example.soundsnap.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.a04_11_abschluss.R
import com.example.a04_11_abschluss.components.AppBackground
import com.example.a04_11_abschluss.components.CountrySelector
import com.example.a04_11_abschluss.components.SearchBar
import com.example.a04_11_abschluss.components.SearchItem
import com.example.a04_11_abschluss.navigation.PlayRoute
import com.example.a04_11_abschluss.viewmodel.TrackViewModel

@Composable
fun SearchScreen(
    navHostController: NavHostController,
    viewModel: TrackViewModel = viewModel()
) {
    var searchTerm by remember { mutableStateOf("") }
    var selectedCountry by remember { mutableStateOf("us") }
    val tracks = viewModel.tracks.collectAsState()
    Column(
        modifier = Modifier
            .padding(4.dp)
            .background(Color.White)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        SearchBar(
            searchTerm = searchTerm,
            onSearchTermChange = { searchTerm = it },
            onSearchClick = { viewModel.fetchTracks(searchTerm, selectedCountry) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        CountrySelector(
            selectedCountry = selectedCountry,
            onCountrySelected = { country ->
                selectedCountry = country
                viewModel.fetchTracks(searchTerm, selectedCountry)
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box {
        AppBackground()
            LazyColumn {
                items(tracks.value) { track ->
                    SearchItem(track, onTrackSelection = {
                        viewModel.selectTrack(track)
                        navHostController.navigate(PlayRoute)
                    })
                }
            }
        }
    }
}