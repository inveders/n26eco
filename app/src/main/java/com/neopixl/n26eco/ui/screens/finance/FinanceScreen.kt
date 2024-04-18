package com.neopixl.n26eco.ui.screens.finance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neopixl.n26eco.model.sumTransactionAmounts
import com.neopixl.n26eco.ui.component.GenericCard
import com.neopixl.n26eco.ui.component.RoundedButton
import com.neopixl.n26eco.ui.component.TransparentCard
import com.neopixl.n26eco.ui.component.spacer
import com.neopixl.n26eco.ui.theme.AppTheme
import com.neopixl.n26eco.ui.theme.N26EcoTheme


@Preview
@Composable
fun FinanceScreen(){
    N26EcoTheme {

        FinanceScreen(totalAmount = 35.5f, ecoAmount = sumTransactionAmounts(), navigateToDetail = {})
    }
}

@Composable
fun FinanceScreen(totalAmount:Float,ecoAmount:Float,navigateToDetail:()->Unit){

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(color = AppTheme.colors.black)){

        spacer(24)

        item {
            Column {
                Text(
                    text = "Espaces",
                    style = AppTheme.typography.montserratTitle2_12,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = AppTheme.colors.white
                )

                Text(
                    text = "$totalAmount €",
                    style = AppTheme.typography.montserratTitle2_12,
                    modifier = Modifier.padding(start = 16.dp, end=16.dp, top = 16.dp),
                    color = AppTheme.colors.white
                )
                Text(
                    text = "Somme disponible",
                    style = AppTheme.typography.montserratText11,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = AppTheme.colors.white
                )
            }
        }

        spacer(24)

        item {
            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround

            ) {
                RoundedButton(
                    text = "Nouvel Espace",
                    onClick = { /*TODO*/ }
                )

                RoundedButton(
                    text = "Automations",
                    hasBorder = true,
                    backgroundColor = AppTheme.colors.white.copy(alpha=0f),
                    icon = Icons.Filled.Star, //TODO debago change icon
                    colorIcon = AppTheme.colors.white,
                    onClick = { /*TODO*/ }
                )
            }
        }

        spacer(16)

        item {
            Column(modifier=Modifier.padding(horizontal = 16.dp)) {
                GenericCard(title = "Compte principal", amount = totalAmount, onClick = {
                    //TODO debago
                })
                Spacer(modifier=Modifier.height(8.dp))
                GenericCard(
                    title = "Compte Eco-Responsable",
                    amount = ecoAmount,
                    cardColor=AppTheme.colors.orange,
                    icon = Icons.Filled.List,
                    onClick = {
                        navigateToDetail()
                    }
                )

            }

        }
        spacer(24)

        item {
            Text(
                text = "Ajouter plus",
                style = AppTheme.typography.montserratTitle2_12,
                fontSize = 15.sp,
                modifier = Modifier.padding(horizontal = 16.dp),
                color = AppTheme.colors.white
            )
        }
        spacer(16)

        item {
            Column(modifier=Modifier.padding(horizontal = 16.dp)) {

                TransparentCard(
                    title = "Instant Savings",
                    description = "Soyez payés mensuelement avec un intérêt annuel à un taux de 2.8%",
                    icon = Icons.Filled.ShoppingCart
                )
                Spacer(modifier = Modifier.height(16.dp))
                TransparentCard(
                    title = "Rejoins un compte",
                    description = "Créer en quelques minutes, un système de gestion financière.",
                    icon = Icons.Filled.ShoppingCart
                )
                Spacer(modifier = Modifier.height(16.dp))
                TransparentCard(
                    title = "Crypto",
                    description = "Débutez avec les cryptomonies",
                    icon = Icons.Filled.ShoppingCart
                )
            }
        }
        spacer(16)
    }

}