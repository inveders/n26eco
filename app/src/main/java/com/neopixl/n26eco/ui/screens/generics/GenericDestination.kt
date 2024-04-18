package com.neopixl.n26eco.ui.screens.generics

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.neopixl.n26eco.navigation.N26NavigationDestination
import com.neopixl.n26eco.navigation.addArgumentsPlaceholder

object GenericDestination : N26NavigationDestination {
    override val route = "generic"
    override val destination = "genericDestination"
}

fun NavGraphBuilder.genericGraph(
    onBackClick: () -> Unit,
    showSnackBar: (Int, Int) -> Unit,
    onNavigateToDestination: (N26NavigationDestination, String) -> Unit
) {
    composable(
        route = GenericDestination.route,
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() },
        popEnterTransition = { fadeIn() },
        popExitTransition = { fadeOut() }
    ) {
        GenericRoute(
            onBack = onBackClick,
            showSnackbar = showSnackBar,
        )
    }
}