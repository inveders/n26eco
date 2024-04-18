package com.neopixl.n26eco.ui.screens.invest

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.neopixl.n26eco.navigation.N26NavigationDestination
import com.neopixl.n26eco.ui.screens.detail.DetailRoute

object InvestDestination : N26NavigationDestination {
    override val route = "invest"
    override val destination = "investDestination"
}

fun NavGraphBuilder.investGraph(
    onBackClick: () -> Unit,
    showSnackBar: (Int, Int) -> Unit,
    onNavigateToDestination: (N26NavigationDestination, String) -> Unit
) {
    composable(
        route = InvestDestination.route,
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() },
        popEnterTransition = { fadeIn() },
        popExitTransition = { fadeOut() }
    ) {
        InvestRoute(
            onBack = onBackClick,
            showSnackbar = showSnackBar,
        )
    }
}