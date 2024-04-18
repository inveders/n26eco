package com.neopixl.n26eco.navigation

import com.neopixl.n26eco.ui.screens.detail.DetailDestination
import com.neopixl.n26eco.ui.screens.generics.GenericDestination
import com.neopixl.n26eco.ui.screens.invest.InvestDestination

fun navigateToInvest(): String {
    return InvestDestination.route
}

fun navigateToDetail(): String {
    return DetailDestination.route
}