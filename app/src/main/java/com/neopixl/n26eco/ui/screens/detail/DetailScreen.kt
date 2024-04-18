package com.neopixl.n26eco.ui.screens.detail

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailScreen(navigateToInvest:()->Unit){

    Button(onClick = navigateToInvest) {
        Text("INVEST")
    }

}