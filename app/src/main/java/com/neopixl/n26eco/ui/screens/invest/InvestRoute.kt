package com.neopixl.n26eco.ui.screens.invest

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun InvestRoute(
    onBack: () -> Unit,
    showSnackbar: (Int, Int) -> Unit,
){
    InvestScreen(onBack)
}