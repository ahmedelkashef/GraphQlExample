package com.plcoding.graphqlcountriesapp.data.reposistory

import com.plcoding.graphqlcountriesapp.Response
import com.plcoding.graphqlcountriesapp.data.datasources.ApolloCountryDataSource
import com.plcoding.graphqlcountriesapp.data.datasources.RetrofitDataSource
import com.plcoding.graphqlcountriesapp.data.map
import com.plcoding.graphqlcountriesapp.domain.model.DetailedCountry
import com.plcoding.graphqlcountriesapp.domain.reposistory.CountryRepo

class CountryRepoImpl(
    val apolloDataSource: ApolloCountryDataSource
) : CountryRepo {
    override suspend fun getCountries(code:String): DetailedCountry? {
       // here you can return any of your data dependent on which client
        // here i returned the GraphQl
        // if you want to use Rest api just change Apollo Client with Retrofit Client and it will work
        return apolloDataSource.getCountries(code).map()
    }

}