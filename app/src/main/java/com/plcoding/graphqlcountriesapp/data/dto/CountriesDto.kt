package com.plcoding.graphqlcountriesapp.data.dto

import com.plcoding.graphqlcountriesapp.domain.model.DetailedCountry

data class CountriesDto(
     val code: String,
     val name: String,
     val capital: String?,
     val emoji: String,
     val currency: String?,
     val languages: List<Language>,
     val continent: Continent,
)

 data class Language(
     val name: String?,
)

 data class Continent(
     val name: String,
)


