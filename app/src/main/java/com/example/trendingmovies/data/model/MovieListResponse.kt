package com.example.trendingmovies.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieListResponse(
    val page: Int,
    val results: MutableList<Movie>,
    val totalPages: Int,
    val totalResult: Int
): Parcelable
