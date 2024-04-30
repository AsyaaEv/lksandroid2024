package com.example.lombalks.api.users

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse {
    @SerializedName("data")
    @Expose
    var data : User? = null

    class User{
        @SerializedName("token")
        @Expose
        var token : String? = null

        @SerializedName("fullname")
        @Expose
        var name : String? = null
    }
}