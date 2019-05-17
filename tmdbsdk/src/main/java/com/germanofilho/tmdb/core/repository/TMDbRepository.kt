package com.germanofilho.tmdb.core.repository

import com.germanofilho.tmdb.core.model.domain.callback.CallbackBoundary
import com.germanofilho.tmdb.core.model.domain.entity.MovieDetail
import com.germanofilho.tmdb.core.model.domain.entity.MovieVideo
import com.germanofilho.tmdb.core.model.domain.entity.PopularMovieList
import com.germanofilho.tmdb.core.model.domain.entity.SearchMovie
import com.germanofilho.tmdb.core.service.ApiFactory
import com.germanofilho.tmdb.core.service.TMDbEndPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class TMDbRepository : ITMDbRepository {

    private var service : TMDbEndPoint = ApiFactory.retrofit().create(TMDbEndPoint::class.java)

    override fun getPopularMovies(page : Int, callback: CallbackBoundary<PopularMovieList>) {
        service.getPopularMovie(page).enqueue(object : Callback<PopularMovieList> {
            override fun onResponse(call: Call<PopularMovieList>, response: Response<PopularMovieList>) {
                if (response.isSuccessful) {
                    callback.success(response.body()!!)
                } else {
                    try {
                        callback.error(Throwable())
                    } catch (e: IOException) {
                        callback.error(e)
                    }
                }
            }

            override fun onFailure(call: Call<PopularMovieList>, t: Throwable) {
                callback.error(t)
            }
        })
    }

    override fun getMovieDetail(idMovie : Int, callback: CallbackBoundary<MovieDetail>) {
        service.getMovieDetail(idMovie).enqueue(object : Callback<MovieDetail> {
            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                if (response.isSuccessful) {
                    callback.success(response.body()!!)
                } else {
                    try {
                        callback.error(Throwable())
                    } catch (e: IOException) {
                        callback.error(e)
                    }
                }
            }

            override fun onFailure(call: Call<MovieDetail>, t: Throwable) {
                callback.error(t)
            }
        })
    }

    override fun getMovieVideo(idMovie: Int, callback: CallbackBoundary<MovieVideo>) {
        service.getMovieVideo(idMovie).enqueue(object : Callback<MovieVideo> {
            override fun onResponse(call: Call<MovieVideo>, response: Response<MovieVideo>) {
                if (response.isSuccessful) {
                    callback.success(response.body()!!)
                } else {
                    try {
                        callback.error(Throwable())
                    } catch (e: IOException) {
                        callback.error(e)
                    }
                }
            }

            override fun onFailure(call: Call<MovieVideo>, t: Throwable) {
                callback.error(t)
            }
        })
    }

    override fun getSearchMovie(query: String, page: Int, includeAdult: Boolean, callback: CallbackBoundary<SearchMovie>) {
        service.getSearchMovie(1, query, includeAdult).enqueue(object : Callback<SearchMovie> {
            override fun onResponse(call: Call<SearchMovie>, response: Response<SearchMovie>) {
                if (response.isSuccessful) {
                    callback.success(response.body()!!)
                } else {
                    try {
                        callback.error(Throwable())
                    } catch (e: IOException) {
                        callback.error(e)
                    }
                }
            }

            override fun onFailure(call: Call<SearchMovie>, t: Throwable) {
                callback.error(t)
            }
        })
    }
}