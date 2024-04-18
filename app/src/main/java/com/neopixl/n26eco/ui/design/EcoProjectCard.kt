package com.neopixl.n26eco.ui.design

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.neopixl.n26eco.model.EcoProject
import com.neopixl.n26eco.model.EcoProjectMock
import com.neopixl.n26eco.ui.theme.AppTheme
import com.neopixl.n26eco.ui.theme.N26EcoTheme

@Composable
fun EcoProjectCard(
	modifier: Modifier = Modifier,
	project: EcoProject
) {
	Surface(
		modifier = modifier,
		shape = RoundedCornerShape(16.dp),
		shadowElevation = 3.dp,
		color = AppTheme.colors.white
	) {
		Column {
			Box {
				AsyncImage(
					modifier = Modifier
						.fillMaxWidth()
						.aspectRatio(16 / 9f)
						.clipToBounds(),
					model = project.imageUrl,
					contentDescription = project.shortDescription,
					contentScale = ContentScale.FillBounds
				)
				Text(
					modifier = Modifier
						.align(Alignment.BottomEnd)
						.padding(10.dp)
						.background(
							color = AppTheme.colors.black,
							shape = RoundedCornerShape(50.dp)
						)
						.padding(
							horizontal = 5.dp,
							vertical = 2.dp
						),
					text = "${project.location?.country}, ${project.location?.city}",
					fontWeight = FontWeight.ExtraBold,
					color = AppTheme.colors.white
				)
			}
			Column (
				modifier = Modifier.padding(10.dp),
				verticalArrangement = Arrangement.spacedBy(10.dp)
			) {
				Text(
					modifier = Modifier,
					text = project.name ?: "",
					fontWeight = FontWeight.Bold,
					color = AppTheme.colors.black
				)
				Text(
					text = project.shortDescription ?: "",
					fontStyle = FontStyle.Italic,
					color = AppTheme.colors.black
				)
				project.investment?.let { investment ->
					ProjectInvestmentBar(investment = investment)
				}
			}
		}
	}
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EcoProjectCardPreview() {
	N26EcoTheme {
		EcoProjectCard(
			modifier = Modifier.fillMaxSize(),
			project = EcoProjectMock().project1
		)
	}
}


