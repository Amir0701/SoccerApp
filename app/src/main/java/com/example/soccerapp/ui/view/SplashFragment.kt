package com.example.soccerapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.soccerapp.R
import com.example.soccerapp.ui.model.MainActivityViewModel
import java.text.SimpleDateFormat
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

    override fun onStart() {
        super.onStart()
        mainActivityViewModel = (activity as MainActivity).mainActivityViewModel
        observe()
        val calendar = Calendar.getInstance()
        val dateString = reformat(calendar.time)
        val targetFormat = SimpleDateFormat("yyyy-MM-dd")
        val formattedDate = targetFormat.parse(dateString)
        formattedDate?.let { mainActivityViewModel.getMatchesByDate(it) }
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
            findNavController().popBackStack()
            findNavController().navigate(R.id.matchesFragment)
        })
    }

    private fun reformat(date: Date): String{
        val format = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(format, Locale.ENGLISH)
        return simpleDateFormat.format(date)
    }
}