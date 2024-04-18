package com.neopixl.n26eco

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.neopixl.n26eco.navigation.N26AppState
import com.neopixl.n26eco.navigation.NavigationGraph
import com.neopixl.n26eco.navigation.rememberN26AppState
import com.neopixl.n26eco.ui.theme.AppTheme
import com.neopixl.n26eco.ui.theme.N26EcoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //TODO debago put it int the future enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {

            N26EcoTheme{
                // A surface container using the 'background' color from the theme
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppTheme.colors.white
                ) {
                    MainScreenView()
                }
            }
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    N26EcoTheme {
        MainScreenView()
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    val appState: N26AppState = rememberN26AppState(navController = navController)
    val ctx = LocalContext.current
    navController.addOnDestinationChangedListener { _, _, _ ->

    }

    Scaffold(
        snackbarHost = {
            Box(modifier = Modifier.fillMaxSize()) {
                SnackbarHost(
                    hostState = appState.snackBarHostState,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 100.dp, start = 24.dp, end = 24.dp),
                    snackbar = { snackbarData: SnackbarData ->
                       /* N26Banner(
                            title = snackbarData.visuals.actionLabel,
                            text = snackbarData.visuals.message,
                            onDismiss = { snackbarData.dismiss() })*/
                    })
            }

        },
    ) { padding ->
        NavigationGraph(
            navController = navController,
            modifier = Modifier.padding(padding),
            showSnackBar = { title, message ->
                appState.showSnackBar(title = title, message = message)
            },
            onNavigateToDestination = appState::navigate,
            onBackClick = appState::onBackClick,
        )
    }
}