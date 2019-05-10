package com.germanofilho.tmdb

class TMDbConfiguration{

    private lateinit var apiKey : String
    private var apiVersion : Int = 3

    fun setApiKey(apiKey: String){
        this.apiKey = apiKey
    }

    /**
     * Change Api Version by default 3
     */
    fun setApiVersion(apiVersion : Int){
        this.apiVersion = apiVersion
    }

    fun getApiKey() = apiKey

}