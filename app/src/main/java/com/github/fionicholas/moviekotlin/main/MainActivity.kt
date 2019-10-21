package com.github.fionicholas.moviekotlin.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.github.fionicholas.moviekotlin.R
import com.github.fionicholas.moviekotlin.detail.DetailActivity
import com.github.fionicholas.moviekotlin.model.Movie
import com.github.fionicholas.moviekotlin.network.ApiRepository
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private var movies: MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            padding = dip(8)

            recyclerView = recyclerView {
                lparams(width = matchParent,  height = wrapContent)
                layoutManager = GridLayoutManager(applicationContext, 2)
            }
        }

        adapter = MainAdapter(movies){
            startActivity<DetailActivity>(
            "TITLE" to it.title,
            "POSTER" to it.posterPath,
            "OVERVIEW" to it.overview,
            "RATING" to it.voteAverage,
            "RELEASE" to it.releaseDate,
            "LANGUAGE" to it.originalLanguage
            )
        }

        recyclerView.adapter = adapter
        presenter = MainPresenter(this, ApiRepository(), Gson())
        presenter.getMovieList()
    }

    override fun showMovieList(data: List<Movie>){
        movies.clear()
        movies.addAll(data)
        adapter.notifyDataSetChanged()
    }
}
