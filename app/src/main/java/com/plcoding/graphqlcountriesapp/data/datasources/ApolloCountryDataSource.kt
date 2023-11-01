package com.plcoding.graphqlcountriesapp.data.datasources

import com.apollographql.apollo3.ApolloClient
import com.plcoding.CountryQuery
import com.plcoding.graphqlcountriesapp.Response
import com.plcoding.graphqlcountriesapp.domain.datasource.CountryDataSource

class ApolloCountryDataSource(
    private val apolloClient: ApolloClient
): CountryDataSource {

    override suspend fun getCountries(code:String): Response<CountryQuery.Country?> {
        return Response(
            data = apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
        )
    }
}