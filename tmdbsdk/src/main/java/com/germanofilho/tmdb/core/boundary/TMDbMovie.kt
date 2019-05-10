package com.germanofilho.tmdb.core.boundary

import com.germanofilho.tmdb.core.model.domain.callback.CallbackBoundary
import com.germanofilho.tmdb.core.model.domain.entity.MovieResponse
import com.germanofilho.tmdb.core.repository.TMDbRepository

class TMDbMovie{

    private var repository = TMDbRepository()

    fun getPopularMovies(callbackBoundary: CallbackBoundary<MovieResponse>){
        repository.getPopularMovies(callbackBoundary)
    }
}