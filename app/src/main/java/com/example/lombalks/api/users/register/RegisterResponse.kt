package com.example.lombalks.api.users.register

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterResponse {
    @SerializedName("message")
    @Expose
    val message: String? = null
}