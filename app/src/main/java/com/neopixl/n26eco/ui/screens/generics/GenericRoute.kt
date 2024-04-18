package com.neopixl.n26eco.ui.screens.generics

import androidx.compose.runtime.Composable
import com.neopixl.n26eco.ui.screens.detail.DetailScreen

@Composable
fun GenericRoute(
    onBack: () -> Unit,
    showSnackbar: (Int, Int) -> Unit,
){
    GenericScreen()
}