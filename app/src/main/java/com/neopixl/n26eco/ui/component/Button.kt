package com.neopixl.n26eco.ui.component

import com.neopixl.n26eco.ui.theme.N26EcoTheme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neopixl.n26eco.ui.theme.AppTheme

@Composable
fun RoundedButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: androidx.compose.ui.graphics.Color = AppTheme.colors.green,
    icon: ImageVector = Icons.Filled.Add,
    hasBorder: Boolean = false
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(60.dp) // Set the size of the button
                .background(
                    backgroundColor,
                    CircleShape
                ) // Set the background color and shape
                .border(
                    width = if (hasBorder) 0.5.dp else 0.dp,
                    shape = CircleShape,
                    color = AppTheme.colors.lightGray
                )
                .clickable(onClick = onClick) // Handle button clicks
        ) {
            Icon(
                imageVector = icon, // Use the "+" icon from material icons
                contentDescription = "Add",
                tint = AppTheme.colors.black // Set the icon color
            )
        }
        Text(
            text = text,
            color = AppTheme.colors.white,
            style = AppTheme.typography.montserratText13,
            modifier = Modifier.padding(top = 5.dp)
        )
    }

}

@Preview
@Composable
fun PreviewAddButton() {
    N26EcoTheme {
        RoundedButton(text = "New Space", onClick = { /* Handle click */ })
    }

}

@Preview
@Composable
fun PreviewInvestButton() {
    N26EcoTheme {
        RoundedButton(
            text = "Invest",
            hasBorder = true,
            backgroundColor = AppTheme.colors.black.copy(alpha = 0f),
            icon = Icons.Filled.ThumbUp,
            onClick = { /* Handle click */ })
    }

}
