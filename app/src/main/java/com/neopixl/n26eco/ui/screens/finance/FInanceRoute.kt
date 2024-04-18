package com.neopixl.n26eco.ui.screens.finance

import androidx.compose.runtime.Composable

@Composable
fun FinanceRoute(
    onBack: () -> Unit,
    showSnackbar: (Int, Int) -> Unit,
    navigateToDetail: () -> Unit
) {
    FinanceScreen(totalAmount = 35.5f, ecoAmount = 10f, navigateToDetail = navigateToDetail)
}