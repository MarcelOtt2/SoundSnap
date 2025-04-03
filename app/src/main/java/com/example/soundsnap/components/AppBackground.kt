package com.example.a04_11_abschluss.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.a04_11_abschluss.R

@Composable
fun AppBackground(){
    Image(
        painter = painterResource(id = R.drawable.backgroundplay),
        contentDescription = "Background Image",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Crop,
    )
}
