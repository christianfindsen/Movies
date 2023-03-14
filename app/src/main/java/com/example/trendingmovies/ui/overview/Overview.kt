package com.example.trendingmovies.ui.overview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.trendingmovies.data.model.Movie
import com.example.trendingmovies.ui.MovieViewModel
import com.example.trendingmovies.ui.MovieViewModel.Companion.IMAGE_BASE_URL

@Composable
fun OverviewScreen(viewModel: MovieViewModel, onItemClick: (id: Int) -> Unit) {

    val movies by viewModel.listOfMovies.observeAsState()

    movies?.let {
        LazyColumn {
            items(it.size) { index ->
                MovieItem(movie = it[index], onItemClick = onItemClick)
            }
        }
    }
}

@Composable
private fun MovieItem(movie: Movie, onItemClick: (id: Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 6.dp, bottom = 6.dp)
            .clickable { onItemClick(movie.id)},
        elevation = 2.dp,
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .padding(start = 12.dp),
                model = IMAGE_BASE_URL + movie.poster_path,
                contentDescription = null
            )

            Text(
                modifier = Modifier
                    .padding(start = 8.dp, end = 16.dp)
                    .weight(1f),
                text = movie.original_title
            )


            Box(
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = "Rating: ${movie.vote_average}",
                    modifier = Modifier.padding(end = 12.dp)
                )
            }


        }
    }

}