package com.neopixl.n26eco.navigation

import androidx.annotation.StringRes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.neopixl.n26eco.N26App
import com.neopixl.n26eco.ui.screens.finance.FinanceDestination
import com.neopixl.n26eco.ui.screens.generics.GenericDestination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun rememberN26AppState(
    snackBarHostState: SnackbarHostState = remember { SnackbarHostState() },
    snackBarScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController,
): N26AppState {
    return remember(snackBarHostState, navController, snackBarScope) {
        N26AppState(navController, snackBarHostState, snackBarScope)
    }
}

@Stable
class N26AppState(
    val navController: NavHostController,
    val snackBarHostState: SnackbarHostState,
    val snackBarScope: CoroutineScope
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    /**
     * Top level destinations to be used in the BottomBar
     */
    val topLevelDestinations: List<TopLevelDestination> = listOf(
        TopLevelDestination(
            route = GenericDestination.route,
            destination = GenericDestination.destination,
        ),
        TopLevelDestination(
            route = FinanceDestination.route,
            destination = FinanceDestination.destination,
        ),
        TopLevelDestination(
            route = GenericDestination.route,
            destination = GenericDestination.destination,
        ),
        TopLevelDestination(
            route = GenericDestination.route,
            destination = GenericDestination.destination,
        )
    )

    /**
     * UI logic for navigating to a particular destination in the app. The NavigationOptions to
     * navigate with are based on the type of destination, which could be a top level destination or
     * just a regular destination.
     *
     * Top level destinations have only one copy of the destination of the back stack, and save and
     * restore state whenever you navigate to and from it.
     * Regular destinations can have multiple copies in the back stack and state isn't saved nor
     * restored.
     *
     * @param route: Optional route to navigate to in case the destination contains arguments.
     */

    fun navigate(destination: N26NavigationDestination, route: String? = null) {
        androidx.tracing.trace("Navigation: $destination") {
            if (destination is TopLevelDestination) {
                navController.navigate(route ?: destination.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            } else {
                navController.navigate(route ?: destination.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    popUpTo("home") {
                        saveState = true
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            }
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }

    fun showSnackBar(@StringRes title: Int, @StringRes message: Int) {
        snackBarScope.launch {
            snackBarHostState.showSnackbar(
                message = N26App.appContext.getString(message),
                actionLabel = if (title != 0) N26App.appContext.getString(title) else null,
                duration = SnackbarDuration.Short
            )
        }
    }
}
