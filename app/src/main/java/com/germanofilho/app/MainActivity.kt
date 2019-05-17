package com.germanofilho.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.germanofilho.tmdb.core.boundary.TMDbMovie
import com.germanofilho.tmdb.core.model.domain.callback.CallbackBoundary
import com.germanofilho.tmdb.core.model.domain.entity.MovieDetail
import com.germanofilho.tmdb.core.model.domain.entity.MovieVideo
import com.germanofilho.tmdb.core.model.domain.entity.PopularMovieList
import com.germanofilho.tmdb.core.model.domain.entity.SearchMovie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var tmDbMovie = TMDbMovie()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_popular_movies.setOnClickListener {
            tmDbMovie.getPopularMovies(1, object : CallbackBoundary<PopularMovieList>{
                override fun success(response: PopularMovieList) {
                    Toast.makeText(applicationContext, "Success!", Toast.LENGTH_SHORT).show()
                }

                override fun error(e: Throwable) {
                    Toast.makeText(applicationContext, "Error!", Toast.LENGTH_SHORT).show()
                }
            })
        }

        btn_movie_detail.setOnClickListener {
            tmDbMovie.getMovieDetail(299534, object : CallbackBoundary<MovieDetail>{

                override fun success(response: MovieDetail) {
                    Toast.makeText(applicationContext, "Success!", Toast.LENGTH_SHORT).show()
                }

                override fun error(e: Throwable) {
                    Toast.makeText(applicationContext, "Error!", Toast.LENGTH_SHORT).show()
                }
            })
        }

        btn_movie_video.setOnClickListener {
            tmDbMovie.getMovieVideo(299534, object : CallbackBoundary<MovieVideo>{

                override fun success(response: MovieVideo) {
                    Toast.makeText(applicationContext, "Success!", Toast.LENGTH_SHORT).show()
                }

                override fun error(e: Throwable) {
                    Toast.makeText(applicationContext, "Error!", Toast.LENGTH_SHORT).show()
                }
            })
        }

        btn_search_movie.setOnClickListener {
            tmDbMovie.getSearchMovie("EndGame", object : CallbackBoundary<SearchMovie>{
                override fun success(response: SearchMovie) {
                    Toast.makeText(applicationContext, "Success!", Toast.LENGTH_SHORT).show()
                }

                override fun error(e: Throwable) {
                    Toast.makeText(applicationContext, "Error!", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
