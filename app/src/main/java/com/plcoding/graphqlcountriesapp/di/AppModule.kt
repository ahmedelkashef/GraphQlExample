package com.plcoding.graphqlcountriesapp.di

import com.apollographql.apollo3.ApolloClient
import com.plcoding.graphqlcountriesapp.data.datasources.ApolloCountryDataSource
import com.plcoding.graphqlcountriesapp.data.datasources.RetrofitDataSource
import com.plcoding.graphqlcountriesapp.data.reposistory.CountryRepoImpl
import com.plcoding.graphqlcountriesapp.domain.reposistory.CountryRepo
import com.plcoding.graphqlcountriesapp.domain.usecase.GetCountriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl("BASE_URL")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30.toLong() , TimeUnit.SECONDS)
            .writeTimeout(30.toLong() , TimeUnit.SECONDS)
            .readTimeout(30.toLong() , TimeUnit.SECONDS)
            .build()
    }
    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() : HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
  @Provides
    @Singleton
    fun provideRetrofitClient(retrofit: Retrofit): RetrofitDataSource {
        return RetrofitDataSource(retrofit)
    }

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient): ApolloCountryDataSource {
        return ApolloCountryDataSource(apolloClient)
    }
    @Provides
    @Singleton
    fun provideCountryRepo(retrofitDataSource: RetrofitDataSource): CountryRepo {
        return CountryRepoImpl(retrofitDataSource)
    }

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryRepo: CountryRepo): GetCountriesUseCase {
        return GetCountriesUseCase(countryRepo)
    }

}