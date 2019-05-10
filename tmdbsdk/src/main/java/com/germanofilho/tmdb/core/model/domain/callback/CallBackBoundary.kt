package com.germanofilho.tmdb.core.model.domain.callback

interface CallbackBoundary<T> {

    fun success(response: T)

    fun error(e: Throwable)
}