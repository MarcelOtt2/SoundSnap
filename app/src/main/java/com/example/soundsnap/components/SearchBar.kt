package com.example.a04_11_abschluss.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.a04_11_abschluss.R

@Composable
fun SearchBar(
    searchTerm: String,
    onSearchTermChange: (String) -> Unit,
    onSearchClick: () -> Unit,
) {

        Row(
            modifier = Modifier

                .fillMaxWidth()
                .padding(top = 8.dp, start = 4.dp)
        ) {

            OutlinedTextField(

                value = searchTerm,
                onValueChange = onSearchTermChange,
                label = { Text("Search by keyword") },
                textStyle = TextStyle(color = Color.Black),
                modifier = Modifier.weight(1f),
            )

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(
                onClick = onSearchClick,
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            }
        }
    }
