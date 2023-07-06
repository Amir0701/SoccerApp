package com.example.soccerapp.ui.view

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerapp.R
import com.example.soccerapp.ui.model.MainActivityViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MatchesFragment : Fragment() {
    lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var matchesRecyclerView: RecyclerView
    private lateinit var adapter: MatchesAdapter
    private lateinit var calendar: Calendar
    private lateinit var calendarImageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_matches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val but: Button = view.findViewById(R.id.toSiteButton)
        but.setOnClickListener {
            findNavController().navigate(R.id.action_matchesFragment_to_webViewFragment)
        }

        mainActivityViewModel = (activity as MainActivity).mainActivityViewModel
        observeMatches()
        matchesRecyclerView = view.findViewById(R.id.matchesRecyclerView)
        calendarImageView = view.findViewById(R.id.calendarImage)
        //mainActivityViewModel.getMatchesByDate()
        initRecyclerView()
        calendar = Calendar.getInstance()
    }

    private fun initRecyclerView(){
        adapter = MatchesAdapter()
        matchesRecyclerView.adapter = adapter
        matchesRecyclerView.layoutManager = LinearLayoutManager(context)
        matchesRecyclerView.addItemDecoration(MatchesDecorator())
        adapter.differList.submitList(mainActivityViewModel.matchesLiveData.value?.dataList)
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

    private fun setDateOnClickListener(){
        val datePickerDialogListener = DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
            calendar.set(Calendar.YEAR, i)
            calendar.set(Calendar.MONTH, i2)
            calendar.set(Calendar.DAY_OF_MONTH, i3)
            val formattedDate = reformat(calendar.time)
            mainActivityViewModel.getMatchesByDate(calendar.time)
        }

        calendarImageView.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                datePickerDialogListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun reformat(date: Date): String{
        val format = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(format, Locale.ENGLISH)
        return simpleDateFormat.format(date)
    }
}