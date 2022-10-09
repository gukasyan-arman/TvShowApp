package com.example.tvshowapp.data.repository

import com.example.tvshowapp.data.api.ApiService
import javax.inject.Inject

class TvShowsRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getTvShows() = apiService.getTvShows()
}