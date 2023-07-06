package com.example.soccerapp.ui.view

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView.RecyclerListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soccerapp.R
import com.example.soccerapp.data.model.Data

class MatchesAdapter: RecyclerView.Adapter<MatchesAdapter.ViewHolder>() {
    private val diffCallBack = object : DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    val differList = AsyncListDiffer(this, diffCallBack)

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val leagueLogo: ImageView = itemView.findViewById(R.id.leagueImage)
        val leagueTitle: TextView = itemView.findViewById(R.id.leagueTitle)
        val homeTeamName: TextView = itemView.findViewById(R.id.homeTeamName)
        val homeTeamLogo: ImageView = itemView.findViewById(R.id.homeTeamLogo)
        val awayTeamName: TextView = itemView.findViewById(R.id.awayTeamName)
        val awayTeamLogo: ImageView = itemView.findViewById(R.id.awayTeamLogo)
        val matchDate: TextView = itemView.findViewById(R.id.matchDate)
        val matchTime: TextView = itemView.findViewById(R.id.matchTime)
        val homeScore: TextView = itemView.findViewById(R.id.homeScore)
        val awayScore: TextView = itemView.findViewById(R.id.awayScore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.match_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differList.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentData = differList.currentList[position]
        holder.leagueTitle.text = currentData.league?.name
        Glide.with(holder.itemView)
            .load(currentData.league?.countryFlag)
            .into(holder.leagueLogo)

        currentData.teams?.let {teams ->
            holder.homeTeamName.text = teams.home?.name
            Glide.with(holder.itemView)
                .load(teams.home?.img)
                .into(holder.homeTeamLogo)

            holder.awayTeamName.text = teams.away?.name
            Glide.with(holder.itemView)
                .load(teams.away?.img)
                .into(holder.awayTeamLogo)
        }

        holder.matchTime.text = currentData.time?.time?.substring(0, 5)
        holder.matchDate.text = currentData.time?.date
        holder.homeScore.text = currentData.scores?.homeScore
        holder.awayScore.text = currentData.scores?.awayScore
    }
}