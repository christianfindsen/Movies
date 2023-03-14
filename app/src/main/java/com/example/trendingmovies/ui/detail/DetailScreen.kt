package com.example.trendingmovies.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.trendingmovies.ui.MovieViewModel


@Composable
fun DetailScreen(
    viewModel: MovieViewModel
) {
    val movie by viewModel.movie.observeAsState()

    movie?.let {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                model = MovieViewModel.IMAGE_BASE_URL + it.poster_path,
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp, 200.dp)
                    .padding(top = 16.dp, bottom = 12.dp)
            )

            Text(
                text = it.original_title,
                modifier = Modifier.padding(24.dp)
            )
            Text(
                text = it.overview,
                modifier = Modifier.padding(24.dp),
                textAlign = TextAlign.Center
            )
        }

    }


}