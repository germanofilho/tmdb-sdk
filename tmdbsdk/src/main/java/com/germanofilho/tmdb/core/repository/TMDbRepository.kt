package com.germanofilho.tmdb.core.repository

import com.germanofilho.tmdb.core.model.domain.callback.CallbackBoundary
import com.germanofilho.tmdb.core.model.domain.entity.MovieResponse
import com.germanofilho.tmdb.core.service.ApiFactory
import com.germanofilho.tmdb.core.service.TMDbEndPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class TMDbRepository : ITMDbRespository {

    private var service : TMDbEndPoint = ApiFactory.retrofit().create(TMDbEndPoint::class.java)

    override fun getPopularMovies(callback: CallbackBoundary<MovieResponse>) {
        service.getPopularMovie().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
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

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                callback.error(t)
            }
        })
    }
}