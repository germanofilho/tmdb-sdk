package com.germanofilho.tmdb

import android.content.Context

open class TMDb {

    companion object {
        val instance : TMDb by lazy { TMDb() }
    }

    private lateinit var context: Context
    private lateinit var configuration: TMDbConfiguration

    fun init(context: Context, configuration: TMDbConfiguration){
        instance.context = context
        instance.configuration = configuration
    }

    fun getConfiguration() : TMDbConfiguration = configuration

    fun getContext() : Context = context
}