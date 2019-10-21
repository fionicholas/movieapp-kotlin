package com.github.fionicholas.moviekotlin.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.github.fionicholas.moviekotlin.BuildConfig.URL_POSTER
import com.github.fionicholas.moviekotlin.R
import com.squareup.picasso.Picasso


class DetailActivity : AppCompatActivity() {

    private  var posterMovie: String = ""
    private  var titleMovie: String = ""
    private  var overviewMovie: String = ""
    private  var ratingMovie: String = ""
    private  var releaseMovie: String = ""
    private  var languangeMovie: String = ""

    private lateinit var poster: ImageView
    private lateinit var title: TextView
    private lateinit var overview: TextView
    private lateinit var rating: TextView
    private lateinit var release: TextView
    private lateinit var language: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.title = "Detail Movie"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        title = findViewById(R.id.usertitle)
        rating = findViewById(R.id.userrating)
        release = findViewById(R.id.userrelease)
        language = findViewById(R.id.userlanguage)
        overview = findViewById(R.id.useroverview)
        poster = findViewById(R.id.poster)

        val i = intent
        titleMovie = i.getStringExtra("TITLE")
        overviewMovie = i.getStringExtra("OVERVIEW")
        posterMovie = i.getStringExtra("POSTER")
        ratingMovie = i.getStringExtra("RATING")
        releaseMovie = i.getStringExtra("RELEASE")
        languangeMovie = i.getStringExtra("LANGUAGE")

        title.text = titleMovie
        overview.text = overviewMovie
        rating.text = ratingMovie
        release.text = releaseMovie
        language.text = languangeMovie
        Picasso.get().load(URL_POSTER + posterMovie).into(poster)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {

            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
