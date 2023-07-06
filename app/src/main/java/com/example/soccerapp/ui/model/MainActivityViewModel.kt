package com.example.soccerapp.ui.model

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccerapp.data.model.SoccerMetaData
import com.example.soccerapp.data.repository.SoccerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(val soccerRepository: SoccerRepository): ViewModel() {
    val matchesLiveData = MutableLiveData<SoccerMetaData>()

    fun getMatchesByDate() = viewModelScope.launch(Dispatchers.IO){

    }
}