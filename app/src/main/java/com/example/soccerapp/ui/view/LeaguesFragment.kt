package com.example.soccerapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerapp.R
import com.example.soccerapp.ui.model.MainActivityViewModel

class LeaguesFragment : Fragment() {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var leagueRecyclerView: RecyclerView
    private lateinit var adapter: LeagueAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leagues, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivityViewModel = (activity as MainActivity).mainActivityViewModel
        leagueRecyclerView = view.findViewById(R.id.leaguesRecycler)
        initRecycler()

        observeLeagues()
        mainActivityViewModel.getAllLeagues()
    }

    private fun initRecycler(){
        adapter = LeagueAdapter()
        leagueRecyclerView.adapter = adapter
        leagueRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun observeLeagues(){
        mainActivityViewModel.leaguesLiveDate.observe(viewLifecycleOwner, Observer {leagues->
            leagues?.let {
                adapter.diffList.submitList(it.data)
            }
        })
    }
}