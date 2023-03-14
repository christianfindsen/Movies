package com.example.trendingmovies.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trendingmovies.data.model.Movie
import com.example.trendingmovies.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch


@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    companion object{
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/original"
    }

    private val _listOfMovies: MutableLiveData<List<Movie>> by lazy { MutableLiveData() }
    val listOfMovies: LiveData<List<Movie>> = _listOfMovies

    private val _movie: MutableLiveData<Movie> by lazy { MutableLiveData() }
    val movie: LiveData<Movie?> = _movie

    var selectedMovie: Int? = null

    init {
        try {
            viewModelScope.launch {
                movieRepository.getMovieList().body()?.results?.let {
                    _listOfMovies.value = it
                }
            }
        } catch (t: Throwable) {
            Log.d("MovieViewModel", "List failed with -> ${t.stackTrace}")
        }
    }

    fun fetchMovieById(id: Int) {
        _movie.value = null
        try {
            viewModelScope.launch {
                movieRepository.getSingleMovie(id).body()?.let {
                    _movie.value = it
                }
            }
        } catch (t: Throwable) {
            Log.d("MovieViewModel", "Movie failed with -> ${t.stackTrace}")
        }
    }




}