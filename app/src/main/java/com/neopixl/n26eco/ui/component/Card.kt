package com.neopixl.n26eco.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neopixl.n26eco.ui.theme.AppTheme
import com.neopixl.n26eco.ui.theme.N26EcoTheme

@Preview(showBackground = true)
@Composable
fun PreviewGreenCard() {
    N26EcoTheme {
        GreenCard(title = "Main Account",amount=35.5f)
    }

}

@Composable
fun GreenCard(title: String, amount:Float,cardColor:Color=AppTheme.colors.green) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp)) // Set corner radius to 8.dp
            .background(cardColor) // Assuming AppTheme.colors.green is defined in your theme
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.Favorite, // Example icon
                    contentDescription = "Example Icon",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = title,
                    color = AppTheme.colors.white,
                    style = AppTheme.typography.montserrat15
                )
            }

            Text(
                text = "$amount €",
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(start = 8.dp)
                ,
                fontSize = 14.sp,
                style = AppTheme.typography.montserratTitle1,
            )
        }
    }
}


@Preview()
@Composable
fun PreviewTransparentCard() {
    N26EcoTheme {
        TransparentCard(
            title = "Instant Savings",
            description = "Join Account",
            icon = Icons.Filled.ShoppingCart
        )
    }
}

@Composable
fun TransparentCard(title: String, description: String, icon: ImageVector) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .border(0.5.dp, AppTheme.colors.lightGray,RoundedCornerShape(4.dp))

            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = title,
                    color = AppTheme.colors.white,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = description,
                    color = AppTheme.colors.white,
                    fontSize = 12.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Icon(
                imageVector = icon,
                contentDescription = "Info Icon",
                tint = Color.Unspecified
            )
        }
    }
}