package com.example.tvshowapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvshowapp.data.repository.TvShowsRepository
import com.example.tvshowapp.models.TvShowResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel
@Inject
constructor (private val repository: TvShowsRepository): ViewModel() {
    private val _response = MutableLiveData<List<TvShowResponseItem>>()
    val responseTvShow: LiveData<List<TvShowResponseItem>>
    get() = _response

    init {
          getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {
        repository.getTvShows().let {response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("responseError", "getAllTvShows Error : ${response.code()}")
            }

        }
    }

}