package com.germanofilho.tmdb.core.service

import com.germanofilho.tmdb.core.model.domain.entity.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TMDbEndPoint{
    @GET("movie/popular")
    fun getPopularMovie(): Call<MovieResponse>

    @GET("movie/{movieId}")
    fun getMovieDetail(@Path("movieId") movieId : Int)
}