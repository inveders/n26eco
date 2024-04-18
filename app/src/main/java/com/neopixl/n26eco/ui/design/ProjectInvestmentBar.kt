package com.neopixl.n26eco.ui.design

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neopixl.n26eco.model.EcoProjectMock
import com.neopixl.n26eco.model.ProjectInvestment
import com.neopixl.n26eco.ui.theme.AppTheme
import kotlin.math.roundToInt

@Composable
fun ProjectInvestmentBar(
	modifier: Modifier = Modifier,
	investment: ProjectInvestment
) {
	val percent = investment.totalInvested?.div(investment.investCost ?: 1f) ?: 0f

	Box(
		modifier = modifier.fillMaxWidth(),
		contentAlignment = Alignment.Center
	) {
		Surface(
			shape = RoundedCornerShape(percent = 50),
			border = BorderStroke(1.dp, AppTheme.colors.green)
		) {
			LinearProgressIndicator(
				modifier = Modifier
					.fillMaxWidth()
					.height(20.dp)
					.clipToBounds(),
				progress = percent,
				color = AppTheme.colors.green,
				trackColor = Color.DarkGray
			)
		}
		Text(
			text = "${investment.totalInvested}€ / ${investment.investCost}€",
			color = AppTheme.colors.white
		)
	}
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProjectInvestmentBarPreview() {
	MaterialTheme {
		EcoProjectMock().project.investment?.let {
			ProjectInvestmentBar(investment = it)
		}
	}
}

