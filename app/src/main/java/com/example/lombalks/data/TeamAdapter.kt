package com.example.lombalks.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.lombalks.MainScreenActivity
import com.example.lombalks.R


class TeamAdapter constructor(private val getActivity: MainScreenActivity, private val dataList : List<TeamData>) :
    RecyclerView.Adapter<TeamAdapter.TeamViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_card_team,parent, false)
        return TeamViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
       holder.teamName.text = dataList[position].nameTeam
       holder.teamLogo.setImageResource(dataList[position].Logo)

        holder.cardView.setOnClickListener{
            Toast.makeText(getActivity, dataList[position].nameTeam, Toast.LENGTH_SHORT).show()
        }
    }

    class TeamViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val teamLogo : ImageView = itemView.findViewById(R.id.teamLogo)
        val teamName : TextView = itemView.findViewById(R.id.teamName)
        val cardView : CardView = itemView.findViewById(R.id.cardView)

    }
}
