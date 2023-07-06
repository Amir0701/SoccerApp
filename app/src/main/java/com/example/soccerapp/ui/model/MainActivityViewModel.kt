package com.example.soccerapp.ui.model

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccerapp.data.api.GsonInstance
import com.example.soccerapp.data.model.Leg
import com.example.soccerapp.data.model.SoccerMetaData
import com.example.soccerapp.data.repository.SoccerRepository
import com.example.soccerapp.util.Util
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivityViewModel(val app: Application,
                            val soccerRepository: SoccerRepository): ViewModel() {
    val matchesLiveData = MutableLiveData<SoccerMetaData>()

    fun getMatchesByDate() = viewModelScope.launch(Dispatchers.IO){
        delay(1000)
        if(hasInternetConnection()){
            Log.i("get match","response body")
            val response = soccerRepository.getMatches(Util.USER, Util.Token)
            Log.i("response succ",response.code().toString())
            val soccerMetaData = getMatchesByDateResponse(response)
            matchesLiveData.postValue(soccerMetaData)
        }
    }

    private fun getMatchesByDateResponse(response: Response<SoccerMetaData>): SoccerMetaData{
        var result = SoccerMetaData(arrayListOf())
        Log.i("body","response body")
        if(response.isSuccessful){
            Log.i("body","response body")
            response.body()?.let {
                Log.i("body","response body")
                result = it
            }
        }

        return result
    }

    fun getAllLeagues() = viewModelScope.launch{
        val response = soccerRepository.getAllLeagues(Util.USER, Util.Token)
        if (response.isSuccessful){
            Log.i("all_good", response.code().toString())
            response.body()?.let {
                //val data = GsonInstance.instance.fromJson(it, Leg::class.java)
                Log.i("all_good", it.data[0].id.toString())
            }
        }
//        val gson = GsonBuilder().create()
//        val data = gson.fromJson(response, Leg::class.java)
//        //val dat = GsonInstance.instance.fromJson(response, Leg::class.java)
//        Log.i("all_good", data.id.toString())
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