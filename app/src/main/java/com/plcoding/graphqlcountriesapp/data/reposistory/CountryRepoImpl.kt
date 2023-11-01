package com.plcoding.graphqlcountriesapp.data.reposistory

import com.plcoding.graphqlcountriesapp.Response
import com.plcoding.graphqlcountriesapp.data.datasources.RetrofitDataSource
import com.plcoding.graphqlcountriesapp.domain.reposistory.CountryRepo

class CountryRepoImpl(
    val retrofitClient: RetrofitDataSource
) : CountryRepo {
    override suspend fun getCountries(code:String): Response<*> {
       // here you can return any of your data dependent which client
        // here i returned the REST api
        // if you want to use GraphQL just change retrofit Client with Apollo Client and it will works
        return retrofitClient.getCountries(code)
    }

}