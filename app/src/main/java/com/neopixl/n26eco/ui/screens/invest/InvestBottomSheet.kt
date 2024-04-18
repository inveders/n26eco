package com.neopixl.n26eco.ui.screens.invest

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvestBottomSheet(onDismiss: () -> Unit) {

    val modalBottomSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        onDismissRequest = {
            onDismiss()
        },
        sheetState = modalBottomSheetState,
        shape = RoundedCornerShape(
            topStart = 16.dp, topEnd = 16.dp
        ),
        tonalElevation = 0.dp,
        dragHandle = {
            BottomSheetDefaults.DragHandle()
        },
        modifier = Modifier.fillMaxSize()
    ) {
        //Sheet content
    }
}