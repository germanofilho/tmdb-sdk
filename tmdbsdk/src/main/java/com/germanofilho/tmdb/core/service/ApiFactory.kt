package com.germanofilho.tmdb.core.service

import com.germanofilho.tmdb.BuildConfig
import com.germanofilho.tmdb.TMDb
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory{
    private val authInterceptor = Interceptor {chain->
        val newUrl = chain.request().url()
            .newBuilder()
            .addQueryParameter("api_key", TMDb.instance.getConfiguration().getApiKey())
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    private val tmdbClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()

    fun retrofit() : Retrofit = Retrofit.Builder()
        .client(tmdbClient)
        .baseUrl(BuildConfig.BASE_API.plus(TMDb.instance.getConfiguration().getApiVersion()).plus("/"))
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}