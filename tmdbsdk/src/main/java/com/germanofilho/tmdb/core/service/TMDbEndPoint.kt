package com.germanofilho.tmdb.core.service

import com.germanofilho.tmdb.core.model.domain.entity.MovieDetail
import com.germanofilho.tmdb.core.model.domain.entity.MovieVideo
import com.germanofilho.tmdb.core.model.domain.entity.PopularMovieList
import com.germanofilho.tmdb.core.model.domain.entity.SearchMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDbEndPoint{
    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page : Int): Call<PopularMovieList>

    @GET("movie/{movieId}")
    fun getMovieDetail(@Path("movieId") movieId : Int) : Call<MovieDetail>

    @GET("movie/{movieId}/videos")
    fun getMovieVideo(@Path("movieId") movieId : Int) : Call<MovieVideo>

    @GET("search/movie")
    fun getSearchMovie(@Query("page") page : Int,
                       @Query("query") query : String,
                       @Query("include_adult") includeAdult : Boolean) : Call<SearchMovie>
}