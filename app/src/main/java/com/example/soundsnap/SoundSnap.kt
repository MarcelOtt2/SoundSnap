package com.example.soundsnap

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.a04_11_abschluss.navigation.AppNavHost
import com.example.a04_11_abschluss.navigation.NavigationItem
import com.example.a04_11_abschluss.viewmodel.TrackViewModel
import com.example.a04_11_abschluss.viewmodel.AuthViewModel
import kotlin.apply
import kotlin.collections.forEach


@Composable
fun SoundSnap() {
    val navHostController = rememberNavController()
    var selectedNavItem by rememberSaveable { mutableStateOf(NavigationItem.Play) }
    
    val viewModel: TrackViewModel = viewModel()
    val firebaseViewModel: AuthViewModel = viewModel()
    var isDarkMode by remember { mutableStateOf(false) }

    Scaffold(topBar = {}, bottomBar = {
        BottomAppBar {
            NavigationItem.entries.forEach {
                NavigationBarItem(selected = selectedNavItem == it, onClick = {
                    selectedNavItem = it
                    navHostController.navigate(it.route)
                }, icon = {
                    Icon(
                        imageVector = it.icon, contentDescription = it.name
                    )
                }, label = {
                    Text(text = stringResource(it.label))
                })
            }
        }
    }, snackbarHost = {}, floatingActionButton = {}, content = {
        val modifier = Modifier
        modifier.fillMaxSize().padding(it).apply {
                AppNavHost(
                    viewModel = viewModel,
                    navHostController = navHostController,
                    isDarkMode = isDarkMode,
                    onChange = { new ->
                        isDarkMode = new
                    },
                    modifier = modifier,
                    authViewModel = firebaseViewModel,
                )
            }
    })
}