package com.neopixl.n26eco.ui.screens.invest

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neopixl.n26eco.model.EcoProject
import com.neopixl.n26eco.model.EcoProjectMock
import com.neopixl.n26eco.ui.component.RoundedButton
import com.neopixl.n26eco.ui.design.EcoProjectCard
import com.neopixl.n26eco.ui.theme.AppTheme
import com.neopixl.n26eco.ui.theme.N26EcoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvestScreen(onBack: () -> Unit) {
    val coroutineScope = rememberCoroutineScope()
    var showSheet by remember { mutableStateOf(false) }
    val projects = listOf(
        EcoProjectMock().project,
        EcoProjectMock().project,
        EcoProjectMock().project,
        EcoProjectMock().project,
        EcoProjectMock().project
    )
    var selectedCard by remember { mutableStateOf(projects.first()) }

    if (showSheet) {
        InvestBottomSheet(selectedCard) {
            showSheet = false
        }
    }

    LazyColumn(
        Modifier.background(
            color = AppTheme.colors.white.copy(alpha = 0.9f)
        )
    ) {
        //Open the bottom sheet on click on card
        item {
            InvestScreenHeader(onBack)
        }

        items(projects) { project ->
            EcoProjectCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1 / 4f)
                    .padding(15.dp)
                    .clickable {
                        selectedCard = project
                        showSheet = true
                    },
                project = project
            )
        }
    }
}

@Composable
fun InvestScreenHeader(onBack: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(AppTheme.colors.white),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        IconButton(onClick = { onBack() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = AppTheme.colors.black
            )
        }
        Text(
            text = "Liste des investissements",
            color = AppTheme.colors.black
        )
        Spacer(modifier = Modifier)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun InvestScreenPreview() {
    N26EcoTheme {
        InvestScreen({})
    }
}
