package com.plcoding.graphqlcountriesapp.data.datasources

import com.plcoding.graphqlcountriesapp.Response
import com.plcoding.graphqlcountriesapp.data.dto.CountriesDto
import com.plcoding.graphqlcountriesapp.domain.datasource.CountryDataSource
import retrofit2.Retrofit

class RetrofitDataSource(
    val retrofitClient: Retrofit
) : CountryDataSource {
    override suspend fun getCountries(code:String): Response<CountriesDto> {
       return Response(
           retrofitClient.create(CountryApi::class.java).getCountries(code)
       )
    }
}