package com.plcoding.graphqlcountriesapp.data.datasources

import com.plcoding.graphqlcountriesapp.data.dto.CountriesDto
import retrofit2.http.GET

interface CountryApi {

    @GET("getCountries")
    suspend fun getCountries(code: String): CountriesDto

}