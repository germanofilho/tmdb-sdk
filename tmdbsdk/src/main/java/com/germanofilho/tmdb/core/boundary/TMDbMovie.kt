package com.germanofilho.tmdb.core.boundary

import com.germanofilho.tmdb.core.model.domain.callback.CallbackBoundary
import com.germanofilho.tmdb.core.model.domain.entity.MovieDetail
import com.germanofilho.tmdb.core.model.domain.entity.MovieVideo
import com.germanofilho.tmdb.core.model.domain.entity.PopularMovieList
import com.germanofilho.tmdb.core.model.domain.entity.SearchMovie
import com.germanofilho.tmdb.core.repository.TMDbRepository

class TMDbMovie{

    private var repository = TMDbRepository()

    fun getPopularMovies(page: Int, callbackBoundary: CallbackBoundary<PopularMovieList>){
        repository.getPopularMovies(page, callbackBoundary)
    }

    fun getPopularMovies(callbackBoundary: CallbackBoundary<PopularMovieList>){
        repository.getPopularMovies(1, callbackBoundary)
    }

    fun getMovieDetail(movieId: Int, callbackBoundary: CallbackBoundary<MovieDetail>){
        repository.getMovieDetail(movieId, callbackBoundary)
    }

    fun getMovieVideo(movieId: Int, callbackBoundary: CallbackBoundary<MovieVideo>){
        repository.getMovieVideo(movieId, callbackBoundary)
    }

    fun getSearchMovie(query: String, callbackBoundary: CallbackBoundary<SearchMovie>){
        repository.getSearchMovie(query, 1, false, callbackBoundary)
    }

    fun getSearchMovie(query: String, page: Int, callbackBoundary: CallbackBoundary<SearchMovie>){
        repository.getSearchMovie(query, page, false, callbackBoundary)
    }

    fun getSearchMovie(query: String, includeAdult : Boolean, callbackBoundary: CallbackBoundary<SearchMovie>){
        repository.getSearchMovie(query, 1, includeAdult, callbackBoundary)
    }

    fun getSearchMovie(query: String, page: Int, includeAdult : Boolean, callbackBoundary: CallbackBoundary<SearchMovie>){
        repository.getSearchMovie(query, page, includeAdult, callbackBoundary)
    }
}