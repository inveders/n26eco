package com.neopixl.n26eco.model

data class EcoProject(
	val projectId: String,
	val name: String?,
	val imageUrl: String = "https://www.generationsforpeace.org/wp-content/uploads/2018/03/empty.jpg",
	val location: ProjectLocation?,
	val shortDescription: String?,
	val fullDescription: String?,
	val investment: ProjectInvestment?,
	val benefits: String?
)

data class EcoProjectMock(
	val project : EcoProject = EcoProject(
		"azertyuiop",
		"City park",
		"https://images.adsttc.com/media/images/64e7/c323/f…dade-seis-projetos-bem-sucedidos_2.jpg?1692910384",
		ProjectLocation(
			"Luxembourg",
			"Differdange"
		),
		"La ville de Differdange veut construire un nouveau park vert.",
		"La ville de Differdange veut construire un nouveau park vert. La ville de Differdange veut construire un nouveau park vert. La ville de Differdange veut construire un nouveau park vert. La ville de Differdange veut construire un nouveau park vert. La ville de Differdange veut construire un nouveau park vert. La ville de Differdange veut construire un nouveau park vert. ",
		ProjectInvestment(
			1_000_000.00f,
			750349.5f
		),
		"-326 CO2 / ans"
	)
)

