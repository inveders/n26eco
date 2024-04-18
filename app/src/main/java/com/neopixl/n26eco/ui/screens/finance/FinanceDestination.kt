package com.neopixl.n26eco.ui.screens.finance

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.neopixl.n26eco.navigation.N26NavigationDestination
import com.neopixl.n26eco.navigation.navigateToDetail
import com.neopixl.n26eco.ui.screens.detail.DetailDestination

object FinanceDestination : N26NavigationDestination {
    override val route = "finance"
    override val destination = "financeDestination"
}

fun NavGraphBuilder.financeGraph(
    onBackClick: () -> Unit,
    showSnackBar: (Int, Int) -> Unit,
    onNavigateToDestination: (N26NavigationDestination, String) -> Unit
) {
    composable(
        route = FinanceDestination.route,
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() },
        popEnterTransition = { fadeIn() },
        popExitTransition = { fadeOut() }
    ) {
        FinanceRoute(
            onBack = onBackClick,
            showSnackbar = showSnackBar,
            navigateToDetail = {
                onNavigateToDestination(
                    DetailDestination, navigateToDetail()
                )
            }
        )
    }
}