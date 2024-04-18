package com.neopixl.n26eco.navigation

data class TopLevelDestination(
    override val route: String,
    override val destination: String,
) : N26NavigationDestination