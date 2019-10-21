package com.github.fionicholas.moviekotlin.model

import com.google.gson.annotations.SerializedName

data class Movie (
  val title: String,
  val id: String,
@SerializedName("poster_path")
  val posterPath: String,
  val overview: String,
@SerializedName("original_language")
  val originalLanguage: String,
@SerializedName("vote_average")
  val voteAverage: String,
@SerializedName("release_date")
  val releaseDate: String
)