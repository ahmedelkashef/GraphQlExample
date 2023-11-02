package com.plcoding.graphqlcountriesapp.domain.reposistory

import com.plcoding.graphqlcountriesapp.Response
import com.plcoding.graphqlcountriesapp.domain.model.DetailedCountry

interface CountryRepo {
    suspend fun getCountries(code :String): DetailedCountry?
}