package com.neopixl.n26eco.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.neopixl.n26eco.ui.theme.AppTheme
import com.neopixl.n26eco.ui.theme.N26EcoTheme

@Preview(showBackground = true)
@Composable
fun PreviewGreenCard() {
    N26EcoTheme {
        GenericCard(title = "Main Account", amount = 35.5f, onClick = {})
    }

}

@Composable
fun GenericCard(
    title: String,
    amount: Float,
    icon: ImageVector = Icons.Filled.Favorite,
    cardColor: Color = AppTheme.colors.green,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp)) // Set corner radius to 8.dp
            .background(cardColor) // Assuming AppTheme.colors.green is defined in your theme
            .padding(16.dp)
            .clickable {
                onClick()
            }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon, // Example icon
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
                    .padding(start = 8.dp),
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
            .border(0.5.dp, AppTheme.colors.lightGray, RoundedCornerShape(4.dp))

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


@Preview()
@Composable
fun PreviewTransactionCard() {
    N26EcoTheme {
        TransactionCard(
            title = "Greene King",
            description = "Online",
            date = "Friday 27 October",
            logo = "url",
            amount = 35.5f
        )
    }
}

@Composable
fun TransactionCard(
    modifier:Modifier=Modifier,
    title: String,
    description: String,
    date: String,
    logo: String,
    amount: Float
) {

    Column(modifier=modifier) {

        Text(
            text = date,
            color = AppTheme.colors.white,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .border(0.3.dp, AppTheme.colors.lightGray.copy(alpha = 0.5f), RoundedCornerShape(4.dp))

                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {

                  /*  AsyncImage(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(AppTheme.colors.black),
                        model = logo,
                        contentDescription = "",
                        clipToBounds = true,
                        contentScale = ContentScale.FillBounds
                    )*/
                    Column(modifier=Modifier.padding(start = 16.dp)) {
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

                }

                Text(
                    text = "$amount €",
                    color = AppTheme.colors.white,
                    fontSize = 12.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

            }
        }
    }
}