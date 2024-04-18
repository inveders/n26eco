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
		"https://www.jerdonlp.com/wp-content/uploads/2019/03/Park-Jerdon-March14-1110x630.jpg",
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

