package com.github.fionicholas.moviekotlin.network

import com.github.fionicholas.moviekotlin.BuildConfig.API_KEY
import com.github.fionicholas.moviekotlin.BuildConfig.BASE_URL

object ApiService {
    fun getMovie(): String {
        return BASE_URL + API_KEY
    }

}