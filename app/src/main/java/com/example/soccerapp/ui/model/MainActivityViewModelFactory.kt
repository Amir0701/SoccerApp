package com.example.soccerapp.ui.model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.soccerapp.data.repository.SoccerRepository

class MainActivityViewModelFactory(val app: Application,
                                   val soccerRepository: SoccerRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(app, soccerRepository) as T
    }
}