package com.example.soccerapp.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soccerapp.R
import com.example.soccerapp.data.model.League

class LeagueAdapter: RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {
    private val diffUtil = object : DiffUtil.ItemCallback<League>(){
        override fun areItemsTheSame(oldItem: League, newItem: League): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: League, newItem: League): Boolean {
            return oldItem == newItem
        }

    }

    val diffList = AsyncListDiffer(this, diffUtil)

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val leagueLogo: ImageView = itemView.findViewById(R.id.leagueLogo)
        val leagueName: TextView = itemView.findViewById(R.id.leagueName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.league_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return diffList.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentLeague = diffList.currentList[position]
        currentLeague.name?.let {
            holder.leagueName.text = it
        }
        currentLeague.countryFlag?.let {
            Glide.with(holder.itemView)
                .load(it)
                .into(holder.leagueLogo)
        }
    }
}