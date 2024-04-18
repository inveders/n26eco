package com.neopixl.n26eco.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.neopixl.n26eco.ui.screens.detail.detailGraph
import com.neopixl.n26eco.ui.screens.finance.financeGraph
import com.neopixl.n26eco.ui.screens.generics.genericGraph
import com.neopixl.n26eco.ui.screens.invest.InvestDestination
import com.neopixl.n26eco.ui.screens.invest.investGraph

@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    showSnackBar: (Int, Int) -> Unit,
    onNavigateToDestination: (N26NavigationDestination, String) -> Unit,
    onBackClick: () -> Unit
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = InvestDestination.route
    ) {
        detailGraph(
            onBackClick=onBackClick,
            showSnackBar = showSnackBar,
            onNavigateToDestination = onNavigateToDestination
        )

        investGraph(
            onBackClick=onBackClick,
            showSnackBar = showSnackBar,
            onNavigateToDestination = onNavigateToDestination
        )

        financeGraph(
            onBackClick=onBackClick,
            showSnackBar = showSnackBar,
            onNavigateToDestination = onNavigateToDestination
        )

        genericGraph(
            onBackClick=onBackClick,
            showSnackBar = showSnackBar,
            onNavigateToDestination = onNavigateToDestination
        )
    }
}