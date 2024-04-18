package com.neopixl.n26eco.ui.screens.detail

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.neopixl.n26eco.navigation.N26NavigationDestination
import com.neopixl.n26eco.navigation.navigateToInvest
import com.neopixl.n26eco.ui.screens.invest.InvestDestination

object DetailDestination : N26NavigationDestination {
    override val route = "detail"
    override val destination = "detailDestination"
}

fun NavGraphBuilder.detailGraph(
    onBackClick: () -> Unit,
    showSnackBar: (Int, Int) -> Unit,
    onNavigateToDestination: (N26NavigationDestination, String) -> Unit
) {
    composable(
        route = DetailDestination.route,
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() },
        popEnterTransition = { fadeIn() },
        popExitTransition = { fadeOut() },

    ) {
        DetailRoute(
            onBack = onBackClick,
            showSnackbar = showSnackBar,
            navigateToInvest = {
                onNavigateToDestination(
                    InvestDestination, navigateToInvest()
                )
            }
        )
    }
}