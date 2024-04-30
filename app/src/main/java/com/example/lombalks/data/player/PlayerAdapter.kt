package com.example.lombalks.data.player

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.lombalks.PemainActivity
import com.example.lombalks.R

class PlayerAdapter(private val getActivity: PemainActivity, private val dataList: List<PlayerData>) :
    RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_card_player, parent, false)
        return PlayerViewHolder(view)
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.nama.text = dataList[position].name
        holder.role.text = dataList[position].role
        holder.Foto.setImageResource(dataList[position].foto)

        holder.cardViewPlayer.setOnClickListener{
            Toast.makeText(getActivity, dataList[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    class PlayerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val nama : TextView = itemView.findViewById(R.id.playerName)
        val role : TextView = itemView.findViewById(R.id.playerRole)
        val Foto : ImageView = itemView.findViewById(R.id.playerFoto)
        val cardViewPlayer : CardView = itemView.findViewById(R.id.cardViewPlayer)

    }
}