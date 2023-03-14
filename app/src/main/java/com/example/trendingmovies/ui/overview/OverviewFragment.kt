package com.example.trendingmovies.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.trendingmovies.R
import com.example.trendingmovies.ui.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OverviewFragment: Fragment() {

    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                OverviewScreen(viewModel)
                { viewModel.selectedMovie = it
                    findNavController().navigate(R.id.action_from_overview_to_details)
                }
            }
        }
    }


}