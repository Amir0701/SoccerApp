package com.example.soccerapp.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.soccerapp.R
import com.example.soccerapp.ui.model.MainActivityViewModel

class MatchesFragment : Fragment() {
    lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_matches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val but: Button = view.findViewById(R.id.but)
        but.setOnClickListener {
            findNavController().navigate(R.id.action_matchesFragment_to_webViewFragment)
        }

        mainActivityViewModel = (activity as MainActivity).mainActivityViewModel
        observeMatches()
        mainActivityViewModel.getMatchesByDate()
    }

    private fun observeMatches(){
        mainActivityViewModel.matchesLiveData.observe(viewLifecycleOwner, Observer {soccerMetaData->
            soccerMetaData?.let {
                if(it.dataList.isNotEmpty()){
                    Log.i("id data", it.dataList[0].id.toString())
                }
            }
        })
    }
}