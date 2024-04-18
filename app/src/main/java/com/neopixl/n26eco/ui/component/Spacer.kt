package com.neopixl.n26eco.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun LazyListScope.spacer(height:Int){
    item {
        Spacer(modifier= Modifier.height(height.dp))
    }
}