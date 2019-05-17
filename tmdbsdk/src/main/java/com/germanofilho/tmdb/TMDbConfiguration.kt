package com.germanofilho.tmdb

class TMDbConfiguration{

    private lateinit var apiKey : String
    private var apiVersion : Int = 3
    private var debuggingMode : Boolean = false

    fun setApiKey(apiKey: String){
        this.apiKey = apiKey
    }

    /**
     * Change Api Version by default 3
     */
    fun setApiVersion(apiVersion : Int){
        this.apiVersion = apiVersion
    }

    fun setDebbugingMode(debuggingMode: Boolean){
        this.debuggingMode = debuggingMode
    }

    fun debbugingModeEnabled() : Boolean = debuggingMode

    fun getApiVersion() : String = this.apiVersion.toString()

    fun getApiKey() : String = apiKey

}