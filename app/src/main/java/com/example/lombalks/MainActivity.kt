package com.example.lombalks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lombalks.data.TeamAdapter
import com.example.lombalks.data.TeamData

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val SignInButton: Button? = findViewById(R.id.buttonSignIn)
        val SignUpButton : Button? = findViewById(R.id.buttonSignUp)

        SignInButton?.setOnClickListener{
            Intent(this, LoginActivity::class.java).also {
                startActivity(it)
            }
        }
        SignUpButton?.setOnClickListener{
            Intent(this, SignUpActivity::class.java).also {
                startActivity(it)
            }
        }


    }


}