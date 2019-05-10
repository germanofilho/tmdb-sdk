package com.germanofilho.tmdb.core.service

import com.germanofilho.tmdb.core.model.domain.entity.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface TMDbEndPoint{
    @GET("movie/popular")
    fun getPopularMovie(): Call<MovieResponse>
}