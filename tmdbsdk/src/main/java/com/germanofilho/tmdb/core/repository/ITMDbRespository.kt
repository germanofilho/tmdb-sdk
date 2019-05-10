package com.germanofilho.tmdb.core.repository

import com.germanofilho.tmdb.core.model.domain.callback.CallbackBoundary
import com.germanofilho.tmdb.core.model.domain.entity.MovieResponse

interface ITMDbRespository{

    fun getPopularMovies(callback: CallbackBoundary<MovieResponse>)

}