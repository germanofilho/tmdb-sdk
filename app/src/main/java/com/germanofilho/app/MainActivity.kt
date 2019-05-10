package com.germanofilho.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.germanofilho.tmdb.core.boundary.TMDbMovie
import com.germanofilho.tmdb.core.model.domain.callback.CallbackBoundary
import com.germanofilho.tmdb.core.model.domain.entity.MovieResponse

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        TMDbMovie().getPopularMovies(object : CallbackBoundary<MovieResponse>{
            override fun success(response: MovieResponse) {
                //logic success here
            }

            override fun error(e: Throwable) {
                //logic error here
            }
        })

    }
}
