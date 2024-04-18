package com.neopixl.n26eco.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neopixl.n26eco.model.Transaction
import com.neopixl.n26eco.model.getMockedTransactions
import com.neopixl.n26eco.ui.component.RoundedButton
import com.neopixl.n26eco.ui.component.TransactionCard
import com.neopixl.n26eco.ui.component.spacer
import com.neopixl.n26eco.ui.theme.AppTheme
import com.neopixl.n26eco.ui.theme.N26EcoTheme

@Preview
@Composable
fun PreviewDetailScreen() {
    N26EcoTheme {
        DetailScreen(
            totalAmount = 10f,
            transactions = getMockedTransactions(),
            onBack = { /*TODO*/ },
            navigateToInvest = {})
    }
}

@Composable
fun DetailScreen(
    totalAmount: Float,
    transactions: List<Transaction>,
    onBack: () -> Unit,
    navigateToInvest: () -> Unit
) {


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppTheme.colors.black)
    ) {

        item {
            //Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(AppTheme.colors.green)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack, // Example icon
                    contentDescription = "Example Icon",
                    tint = AppTheme.colors.white,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .align(Alignment.TopStart)
                        .clickable { onBack() }
                )

                Icon(
                    imageVector = Icons.Filled.ShoppingCart, // Example icon
                    contentDescription = "Example Icon",
                    tint = AppTheme.colors.white,
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center)
                        .clickable { onBack() }
                )
            }
        }

        spacer(16)

        item {
            Column {
                Text(
                    text = "Compte Eco-Responsable",
                    style = AppTheme.typography.montserratTitle2_12,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = AppTheme.colors.white
                )

                Text(
                    text = "$totalAmount €",
                    style = AppTheme.typography.montserratTitle2_12,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 6.dp),
                    color = AppTheme.colors.white
                )
                Text(
                    text = "Somme disponible",
                    style = AppTheme.typography.montserratText11,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = AppTheme.colors.white
                )
            }
        }

        spacer(24)

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround

            ) {
                RoundedButton(
                    text = "Ajouter",
                    onClick = { /*TODO*/ }
                )

                RoundedButton(
                    text = "Envoyer",
                    hasBorder = true,
                    backgroundColor = AppTheme.colors.white.copy(alpha = 0f),
                    icon = Icons.Filled.ArrowForward, //TODO debago change icon
                    colorIcon = AppTheme.colors.white,
                    onClick = { /*TODO*/ }
                )

                RoundedButton(
                    text = "Investir",
                    hasBorder = true,
                    backgroundColor = AppTheme.colors.orange,
                    icon = Icons.Filled.Share, //TODO debago change icon
                    colorIcon = AppTheme.colors.black,
                    onClick = { navigateToInvest() }
                )
            }
        }

        spacer(24)

        item {
            Column {
                Text(
                    text = "Avril 2024",
                    style = AppTheme.typography.montserratTitle2_12,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = AppTheme.colors.white
                )
            }
        }

        spacer(16)

        itemsIndexed(transactions.sortedByDescending { it.id }) { index, data ->
            TransactionCard(
                title = data.name ?: "",
                description = if (data.isOnline) "En ligne" else "Physique",
                date = data.date,
                logo = data.logoUrl,
                amount = data.amount,
                modifier = Modifier.padding(
                    top = if (index == 0) 0.dp else 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = if (index == getMockedTransactions().lastIndex) 16.dp else 0.dp
                )
            )

        }

    }


}