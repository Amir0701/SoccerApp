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
        mainActivityViewModel.getMatchesByDate()
        mainActivityViewModel.getAllLeagues()
    }
    override fun onResume() {
        super.onResume()
    }

    private fun observe(){
        mainActivityViewModel.matchesLiveData.observe(viewLifecycleOwner, Observer {
            Log.i("data id", it!!.dataList[0].id.toString())
            findNavController().navigate(R.id.action_splashFragment_to_matchesFragment)
        })
    }
}