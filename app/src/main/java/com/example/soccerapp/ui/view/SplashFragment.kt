package com.example.soccerapp.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.soccerapp.R
import com.example.soccerapp.ui.model.MainActivityViewModel
import com.example.soccerapp.util.Util

import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale

class SplashFragment : Fragment() {
    lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        mainActivityViewModel = (activity as MainActivity).mainActivityViewModel
        observe()
        val calendar = Calendar.getInstance()
        reformat(calendar.time)
//        println(calendar.time)
//        val formatter = DateTimeFormatter.ofPattern("d MMMM, yyyy")
//        val date = LocalDate.parse(calendar.time.toString(), formatter)
        //Log.i("date curr", date.toString())
        //mainActivityViewModel.getAllLeagues()
        mainActivityViewModel.getMatchesByDate(calendar.time)
    }
    override fun onResume() {
        super.onResume()
    }

    private fun observe(){
        mainActivityViewModel.matchesLiveData.observe(viewLifecycleOwner, Observer {soccer->
            soccer?.let {
//                if(it.dataList.isNotEmpty())
//                    Log.i("data id", it.dataList[0].id.toString())
            }
            findNavController().navigate(R.id.action_splashFragment_to_matchesFragment)
        })
    }

    private fun reformat(date: Date): String{
        val format = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(format, Locale.ENGLISH)
        val dat = simpleDateFormat.applyPattern(simpleDateFormat.format(date))
        //Log.i("date_curr", dat.)
        return simpleDateFormat.format(date)
    }
}