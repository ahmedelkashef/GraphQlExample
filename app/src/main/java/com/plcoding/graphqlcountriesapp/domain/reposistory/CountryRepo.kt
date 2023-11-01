package com.plcoding.graphqlcountriesapp.domain.reposistory

import com.plcoding.graphqlcountriesapp.Response

interface CountryRepo {
    suspend fun getCountries(code :String): Response<*>
}