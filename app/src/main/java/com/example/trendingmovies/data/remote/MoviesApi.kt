package com.example.trendingmovies.data.remote

import com.example.trendingmovies.BuildConfig
import com.example.trendingmovies.data.model.Movie
import com.example.trendingmovies.data.model.MovieListResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {


    @GET("trending/movie/week?api_key=${BuildConfig.API_KEY}")
    suspend fun getTrendingMovies(): Response<MovieListResponse>

    @GET("movie/{id}?api_key=${BuildConfig.API_KEY}")
    suspend fun getMovieById(
        @Path(value = "id", encoded = true) id: Int): Response<Movie>
}