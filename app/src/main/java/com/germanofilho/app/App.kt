package com.germanofilho.app

import android.app.Application
import com.germanofilho.tmdb.TMDb
import com.germanofilho.tmdb.TMDbConfiguration

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        initTMDbSdk()
    }

    private fun initTMDbSdk(){
        val configuration = TMDbConfiguration()
        configuration.setApiKey("Your TMDb api key here!")
        TMDb.instance.init(applicationContext, configuration)
    }
}