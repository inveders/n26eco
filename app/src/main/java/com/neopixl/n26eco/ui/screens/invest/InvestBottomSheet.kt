package com.neopixl.n26eco.ui.screens.invest

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neopixl.n26eco.model.EcoProject
import com.neopixl.n26eco.model.EcoProjectMock
import com.neopixl.n26eco.ui.theme.AppTheme
import com.neopixl.n26eco.ui.theme.N26EcoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvestBottomSheet(project: EcoProject, onDismiss: () -> Unit) {
    var amount by remember { mutableStateOf("") }

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
        Text(
            text = "${project.name}",
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.ExtraBold,
            color = AppTheme.colors.black
        )

        OutlinedTextField(
            value = "$amount €",
            onValueChange = { amount = it },
            label = { Text("Montant à investir") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { onDismiss() }) {
                Text("Annuler")
            }

            Button(onClick = {  }) {
                Text("Confirmer")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = {  }) {
            Text("Plus d'informations sur le projet")
        }
    }
}

