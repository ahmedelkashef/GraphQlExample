package com.plcoding.graphqlcountriesapp.domain.datasource

import com.plcoding.graphqlcountriesapp.Response

interface CountryDataSource {
    suspend fun getCountries(code:String): Response<*>
}