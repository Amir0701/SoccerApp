package com.example.soccerapp.ui.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.soccerapp.data.repository.SoccerRepository

class MainActivityViewModelFactory(val soccerRepository: SoccerRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(soccerRepository = soccerRepository) as T
    }
}