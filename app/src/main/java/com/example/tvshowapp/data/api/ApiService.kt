package com.example.tvshowapp.data.api

import com.example.tvshowapp.models.TvShowResponse
import com.example.tvshowapp.util.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(END_POINT)
    suspend fun getTvShows(): Response<TvShowResponse>

}