package com.germanofilho.tmdb.core.repository

import com.germanofilho.tmdb.core.model.domain.callback.CallbackBoundary
import com.germanofilho.tmdb.core.model.domain.entity.MovieDetail
import com.germanofilho.tmdb.core.model.domain.entity.PopularMovieList
import com.germanofilho.tmdb.core.model.domain.entity.MovieVideo
import com.germanofilho.tmdb.core.model.domain.entity.SearchMovie

interface ITMDbRepository{

    fun getPopularMovies(page : Int, callback: CallbackBoundary<PopularMovieList>)

    fun getMovieDetail(idMovie : Int, callback: CallbackBoundary<MovieDetail>)

    fun getMovieVideo(idMovie : Int, callback: CallbackBoundary<MovieVideo>)

    fun getSearchMovie( query : String, page : Int, includeAdult : Boolean, callback: CallbackBoundary<SearchMovie>)
}