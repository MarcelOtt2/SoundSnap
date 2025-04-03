package com.example.a04_11_abschluss.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.room.util.TableInfo
import com.google.common.math.LinearTransformation.vertical

@Composable
fun AuthTextEditField(
    value: String,
    icon: ImageVector,
    label: String,
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .padding(horizontal = 60.dp)

    ) {
        OutlinedTextField(

            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.padding(horizontal = 24.dp),
            value = value,
            onValueChange = { onValueChange(it) },
            singleLine = true,
            leadingIcon = {
                Icon(icon, icon.name)
            },
            trailingIcon = {
                IconButton(
                    onClick = { onValueChange("") },
                    content = {
                        if (value.isNotEmpty()) {
                            Icon(Icons.Default.Close, Icons.Default.Close.name)
                        }
                    }
                )
            },
            label = { Text(label) }
        )
    }
}