package com.github.fionicholas.moviekotlin.main

import com.github.fionicholas.moviekotlin.model.MovieResponse
import com.github.fionicholas.moviekotlin.network.ApiRepository
import com.github.fionicholas.moviekotlin.network.ApiService
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView, private val apiRepository: ApiRepository, private val gson: Gson) {

    fun getMovieList(){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(ApiService.getMovie()),
                MovieResponse::class.java)
            uiThread {
                view.showMovieList(data.results)
            }
        }
    }
}