package com.example.lombalks.api.users.register

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterRequest {
    @SerializedName("fullname")
    @Expose
    var fullname : String? = null
    @SerializedName("username")
    @Expose
    var username : String? = null
    @SerializedName("email")
    @Expose
    var email : String? = null
    @SerializedName("password")
    @Expose
    var password : String? = null
}
