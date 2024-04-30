package com.example.lombalks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.lombalks.api.users.ApiConfig
import com.example.lombalks.api.users.register.RegisterApi
import com.example.lombalks.api.users.register.RegisterRequest
import com.example.lombalks.api.users.register.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val iconBack : View = findViewById(R.id.icon_arrow_left)
        val signIn : View = findViewById(R.id.signIn)
        iconBack.setOnClickListener{
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
        signIn.setOnClickListener{
            Intent(this, LoginActivity::class.java).also {
                startActivity(it)
            }
        }

        val inputFullname : EditText = findViewById(R.id.inputFullname)
        val inputUsername : EditText = findViewById(R.id.inputUsername)
        val inputEmail : EditText = findViewById(R.id.inputEmail)
        val inputPassword : EditText = findViewById(R.id.inputPassword)
        val inputCPassword : EditText = findViewById(R.id.inputCPassword)
        val buttonSubmit : Button = findViewById(R.id.button)

        fun alert(string: String){
            Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
            return
        }
        buttonSubmit.setOnClickListener{
            if (inputFullname.text.isNullOrEmpty() || inputUsername.text.isNullOrEmpty() || inputEmail.text.isNullOrEmpty() || inputPassword.text.isNullOrEmpty() || inputCPassword.text.isNullOrEmpty()){
                alert("Input field tidak boleh kosong")
                return@setOnClickListener
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(inputEmail.text.toString()).matches()){
                alert("Kesalahan format email")
                return@setOnClickListener
            }
            if(inputUsername.text.length < 6){
                alert("Username minimal 6 karakter")
                return@setOnClickListener
            }
            if(inputPassword.text.length < 6){
                alert("Password minimal 6 karakter")
                return@setOnClickListener
            }
            if(inputPassword.text.toString() != inputCPassword.text.toString()){
                alert("Password dan confirm password tidak sama!")
                return@setOnClickListener
            }

            val request = RegisterRequest().apply { 
                fullname = inputFullname.text.toString()
                username = inputUsername.text.toString()
                email = inputEmail.text.toString()
                password = inputPassword.text.toString()
            }


            val signup = ApiConfig().getApiConfig().create(RegisterApi::class.java)
            signup.register(request).enqueue(object : Callback<RegisterResponse>{
                override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                    if (response.isSuccessful) {
                        Intent(this@SignUpActivity, LoginActivity::class.java).also {
                            startActivity(it)
                        }
                    } else {
                        alert("Kesalahan Username/Email atau password")
                    }
                }
                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Log.e("error", t.message.toString())
                }
            })
        }
    }
}