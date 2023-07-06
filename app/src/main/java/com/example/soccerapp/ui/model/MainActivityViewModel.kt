package com.example.soccerapp.ui.model

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccerapp.data.model.LeaguesData
import com.example.soccerapp.data.model.SoccerMetaData
import com.example.soccerapp.data.repository.SoccerRepository
import com.example.soccerapp.util.Util
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.Date

class MainActivityViewModel(val app: Application,
                            val soccerRepository: SoccerRepository): ViewModel() {
    val matchesLiveData = MutableLiveData<SoccerMetaData>()
    val leaguesLiveDate = MutableLiveData<LeaguesData>()
    fun getMatchesByDate(date: Date) = viewModelScope.launch(Dispatchers.IO){
        delay(500)
        if(hasInternetConnection()){
            val response = soccerRepository.getMatches(Util.USER, Util.Token, date)
            val soccerMetaData = getMatchesByDateResponse(response)
            matchesLiveData.postValue(soccerMetaData)
        }
    }

    private fun getMatchesByDateResponse(response: Response<SoccerMetaData>): SoccerMetaData{
        var result = SoccerMetaData(arrayListOf())
        if(response.isSuccessful){
            response.body()?.let {
                result = it
            }
        }

        return result
    }

    fun getAllLeagues() = viewModelScope.launch{
        val response = soccerRepository.getAllLeagues(Util.USER, Util.Token)
        val leaguesData = getLeaguesResponse(response)
        leaguesLiveDate.postValue(leaguesData)
    }

    private fun getLeaguesResponse(response: Response<LeaguesData>): LeaguesData{
        var result = LeaguesData(arrayListOf())
        if(response.isSuccessful){
            response.body()?.let {
                result = it
            }
        }

        return result
    }
    private fun hasInternetConnection(): Boolean{
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false

        return when{
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }
}