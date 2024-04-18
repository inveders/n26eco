package com.neopixl.n26eco.ui.screens.detail

import androidx.compose.runtime.Composable
import com.neopixl.n26eco.model.getMockedTransactions
import com.neopixl.n26eco.model.sumTransactionAmounts

@Composable
fun DetailRoute(
    onBack: () -> Unit,
    showSnackbar: (Int, Int) -> Unit,
    navigateToInvest: () -> Unit
) {


    DetailScreen(
        totalAmount = sumTransactionAmounts(),
        transactions = getMockedTransactions(),
        navigateToInvest = navigateToInvest,
        onBack = onBack
    )
}