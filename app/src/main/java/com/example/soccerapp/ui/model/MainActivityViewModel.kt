package com.example.soccerapp.ui.model

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccerapp.data.model.SoccerMetaData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    val matchesLiveData = MutableLiveData<SoccerMetaData>()

    fun getMatchesByDate() = viewModelScope.launch(Dispatchers.IO){

    }
}