package com.example.trendingmovies.repository

import com.example.trendingmovies.data.model.Movie
import com.example.trendingmovies.data.model.MovieListResponse
import com.example.trendingmovies.data.remote.MoviesApi
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.Response

@Singleton
class MovieRepository @Inject constructor(
    private val moviesApi: MoviesApi
) {

    suspend fun getMovieList(): Response<MovieListResponse> {
        return moviesApi.getTrendingMovies()
    }

    suspend fun getSingleMovie(id: Int): Response<Movie> {
        return moviesApi.getMovieById(id)
    }

}