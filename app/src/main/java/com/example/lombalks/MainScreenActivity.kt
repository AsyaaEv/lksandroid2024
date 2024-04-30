package com.example.lombalks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lombalks.data.TeamAdapter
import com.example.lombalks.data.TeamData
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainScreenActivity : AppCompatActivity() {
    private var recyclerView : RecyclerView? = null
    private var recyclerViewTeamAdapter : TeamAdapter? = null
    private var teamList = mutableListOf<TeamData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

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


        val tabPemain : TextView = findViewById(R.id.tabPemain)

        tabPemain.setOnClickListener{
            Intent(this, PemainActivity::class.java).also {
                startActivity(it)
            }
        }

        teamList = ArrayList()
        recyclerView = findViewById<View>(R.id.recycleView) as RecyclerView
        recyclerViewTeamAdapter = TeamAdapter(this, teamList)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this, 1)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewTeamAdapter

        dataTeam()

    }
    private fun dataTeam(){
        var team = TeamData("RRQ", R.drawable.logo)
        teamList.add(team)
        team = TeamData("EVOS", R.drawable.logo)
        teamList.add(team)

        recyclerViewTeamAdapter!!.notifyDataSetChanged()
    }


}