package com.example.lombalks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.lombalks.data.player.PlayerAdapter
import com.example.lombalks.data.player.PlayerData
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class PemainActivity : AppCompatActivity() {
    private var recyclerView : RecyclerView? = null
    private var recyclerViewAdapter : PlayerAdapter? = null
    private var playerList = mutableListOf<PlayerData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemain)

        val username = intent.getStringExtra("name")

        val labelName : TextView = findViewById(R.id.name)
        labelName.text = "$username 👋"

        val textClock : TextClock = findViewById(R.id.textclock)
        val time = SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss a", Locale.getDefault())

        val handler = Handler(Looper.getMainLooper())
        val looping = object : Runnable{
            override fun run() {
                textClock.text = time.format(Date())
                handler.postDelayed(this, 1000)
            }
        }
        handler.post(looping)

        val tabTim : TextView = findViewById(R.id.tabTim
        )
        tabTim.setOnClickListener{
            Intent(this, MainScreenActivity::class.java).also {
                startActivity(it)
            }
        }

        playerList = ArrayList()
        recyclerView = findViewById(R.id.recycleViewPlayer) as RecyclerView
        recyclerViewAdapter = PlayerAdapter(this, playerList)
        val layout : RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recyclerView!!.layoutManager = layout
        recyclerView!!.adapter = recyclerViewAdapter

        dataPlayer()

    }

    fun dataPlayer(){
        var player = PlayerData("Asya", "Midlaner", R.drawable.logo)
        playerList.add(player)

        recyclerViewAdapter!!.notifyDataSetChanged()
    }
}