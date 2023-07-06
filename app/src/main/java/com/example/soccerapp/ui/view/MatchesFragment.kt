package com.example.soccerapp.ui.view

import android.app.DatePickerDialog
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
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
        val toSiteButton: Button = view.findViewById(R.id.toSiteButton)
        toSiteButton.setOnClickListener {
            findNavController().navigate(R.id.action_matchesFragment_to_webViewFragment)
        }

        mainActivityViewModel = (activity as MainActivity).mainActivityViewModel
        observeMatches()
        matchesRecyclerView = view.findViewById(R.id.matchesRecyclerView)
        calendarImageView = view.findViewById(R.id.calendarImage)
        initRecyclerView()
        calendar = Calendar.getInstance()
        setDateOnClickListener()
    }

    private fun initRecyclerView(){
        adapter = MatchesAdapter()
        matchesRecyclerView.adapter = adapter
        when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> matchesRecyclerView.layoutManager = LinearLayoutManager(context)
            Configuration.ORIENTATION_LANDSCAPE -> matchesRecyclerView.layoutManager = GridLayoutManager(context, 2)
            else -> ""
        }
        matchesRecyclerView.addItemDecoration(MatchesDecorator())
        adapter.differList.submitList(mainActivityViewModel.matchesLiveData.value?.dataList)
    }

    private fun observeMatches(){
        mainActivityViewModel.matchesLiveData.observe(viewLifecycleOwner, Observer {soccerMetaData->
            soccerMetaData?.let {
                if(it.dataList.isNotEmpty()){
                    adapter.differList.submitList(it.dataList)
                }
            }
        })
    }

    private fun setDateOnClickListener(){
        val datePickerDialogListener = DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
            calendar.set(Calendar.YEAR, i)
            calendar.set(Calendar.MONTH, i2)
            calendar.set(Calendar.DAY_OF_MONTH, i3)
            val dateString = reformat(calendar.time)
            val targetFormat = SimpleDateFormat("yyyy-MM-dd")
            val formattedDate = targetFormat.parse(dateString)
            mainActivityViewModel.getMatchesByDate(formattedDate)
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