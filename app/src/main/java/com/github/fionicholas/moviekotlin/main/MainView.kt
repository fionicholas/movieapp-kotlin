package com.github.fionicholas.moviekotlin.main

import com.github.fionicholas.moviekotlin.model.Movie

interface MainView {
    fun showMovieList(data: List<Movie>)
}