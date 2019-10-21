package com.github.fionicholas.moviekotlin.main

import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.github.fionicholas.moviekotlin.BuildConfig.URL_POSTER
import com.github.fionicholas.moviekotlin.R
import com.github.fionicholas.moviekotlin.model.Movie
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick


class MainAdapter(private val result: List<Movie>, private val listener: (Movie) -> Unit)
    : RecyclerView.Adapter<MainAdapter.MovieViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
       return MovieViewHolder(MovieItem().createView(AnkoContext.create(p0.context, p0)))
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(p0: MovieViewHolder, p1: Int) {
      p0.bindItem(result[p1], listener)
    }

    class MovieItem : AnkoComponent<ViewGroup>{
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui){
                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(4)
                    orientation = LinearLayout.VERTICAL

                    imageView {
                        id = R.id.movie_poster
                    }.lparams {
                        height = dip(250)
                        width = wrapContent
                    }

                    textView {
                        id = R.id.movie_title
                        textSize = 16f
                        typeface = Typeface.DEFAULT_BOLD
                        maxLines = 1

                    }.lparams{

                    }
                    linearLayout {
                        lparams(width = matchParent, height = wrapContent)
                        orientation = LinearLayout.HORIZONTAL
                    imageView {
                        id = R.id.star_rating
                        setImageResource(R.drawable.ic_star)
                    }.lparams {
                        height = wrapContent
                        width = wrapContent
                    }
                    textView{
                        id = R.id.movie_rating
                        textSize = 14f
                    }.lparams{
                        marginStart = dip(8)
                    }
                    }
                }
            }
        }
    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val moviePoster: ImageView = view.find(R.id.movie_poster)
        private val movieTitle: TextView = view.find(R.id.movie_title)
        private val movieRating: TextView = view.find(R.id.movie_rating)

        fun bindItem(movies: Movie, listener: (Movie) -> Unit){
            Picasso.get().load(URL_POSTER + movies.posterPath).into(moviePoster)
            movieTitle.text = movies.title
            movieRating.text = movies.voteAverage

            moviePoster.onClick {
                listener(movies)
            }

        }
    }
}