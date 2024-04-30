package com.example.lombalks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.lombalks.api.users.ApiConfig
import com.example.lombalks.api.users.UserApi
import com.example.lombalks.api.users.UserRequest
import com.example.lombalks.api.users.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val iconBack : View = findViewById(R.id.icon_arrow_left)
        val signUp : View = findViewById(R.id.signUp)
        val button : Button = findViewById(R.id.button)
        val inputUserEmail : EditText = findViewById(R.id.inputUserEmail)
        val inputPassword : EditText = findViewById(R.id.inputPassword)

        iconBack.setOnClickListener{
            Intent(this, MainActivity::class.java).also{
                startActivity(it)
            }
        }
        signUp.setOnClickListener{
            Intent(this, SignUpActivity::class.java).also{
                startActivity(it)
            }
        }
        fun alert(string: String){
            Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
            return
        }
        button.setOnClickListener{
            if(inputUserEmail.text.isNullOrEmpty() || inputPassword.text.isNullOrEmpty()){
                alert("Input field tidak boleh kosong")
                return@setOnClickListener
            }

            val request = UserRequest()
            request.email = inputUserEmail.text.toString()
            request.password = inputPassword.text.toString()

            val getData = ApiConfig().getApiConfig().create(UserApi::class.java)
            getData.getDataUser(request).enqueue(object : Callback<UserResponse>{
                override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                    if (response.isSuccessful && response.body() != null) {
                        val loginResponse = response.body()
                        val login = Intent(this@LoginActivity, MainScreenActivity::class.java).apply{
                            putExtra("name", loginResponse!!.data?.name)
                        }
                            startActivity(login)

                    } else {
                        alert("Kesalahan Username/Email atau password")
                    }
                }
                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Log.e("error", t.message.toString())
                }
            })
        }
    }
}