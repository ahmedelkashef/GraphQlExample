package com.plcoding.graphqlcountriesapp.data

import com.plcoding.CountryQuery
import com.plcoding.graphqlcountriesapp.data.dto.CountriesDto
import com.plcoding.graphqlcountriesapp.domain.model.DetailedCountry

object CountryMappers {

    fun <T> map(data: T): DetailedCountry? {
        return when (data) {
            is CountryQuery.Country -> {
                data.toDetailedCountry()
            }
            is CountriesDto -> {
                data.toDetailedCountry()
            }
            else -> {
                null
            }
        }
    }
}
private fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}
    private fun CountriesDto.toDetailedCountry(): DetailedCountry {
        return DetailedCountry(
            code = code,
            name = name,
            emoji = emoji,
            capital = capital ?: "No capital",
            currency = currency ?: "No currency",
            languages = languages.mapNotNull { it.name },
            continent = continent.name
        )
    }