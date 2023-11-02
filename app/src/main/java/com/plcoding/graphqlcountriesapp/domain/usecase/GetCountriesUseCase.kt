package com.plcoding.graphqlcountriesapp.domain.usecase

import com.plcoding.graphqlcountriesapp.data.map
import com.plcoding.graphqlcountriesapp.domain.model.DetailedCountry
import com.plcoding.graphqlcountriesapp.domain.reposistory.CountryRepo

class GetCountriesUseCase(
    private val countryRepo: CountryRepo
) {

    suspend fun execute(code :String): DetailedCountry? {
            return countryRepo.getCountries(code)
        }
    }