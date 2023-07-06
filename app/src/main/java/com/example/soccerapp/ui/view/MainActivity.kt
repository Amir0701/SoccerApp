package com.example.soccerapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.soccerapp.R
import com.example.soccerapp.data.api.RetrofitClient
import com.example.soccerapp.data.api.SoccerApiService
import com.example.soccerapp.data.repository.SoccerRepository
import com.example.soccerapp.ui.model.MainActivityViewModel
import com.example.soccerapp.ui.model.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = MainActivityViewModelFactory(
            application,
            SoccerRepository(RetrofitClient.instance.create(SoccerApiService::class.java))
        )
        mainActivityViewModel = ViewModelProvider(this, factory)[MainActivityViewModel::class.java]
        setContentView(R.layout.activity_main)
    }
}