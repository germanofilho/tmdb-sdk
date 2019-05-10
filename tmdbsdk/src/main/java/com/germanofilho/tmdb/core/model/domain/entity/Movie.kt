package com.germanofilho.tmdb.core.model.domain.entity

data class Movie(
    val id: Int,
    val vote_average: Double,
    val title: String,
    val overview: String,
    val adult: Boolean)

data class MovieResponse(val results: List<Movie>)