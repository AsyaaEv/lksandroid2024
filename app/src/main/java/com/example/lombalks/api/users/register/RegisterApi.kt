package com.example.lombalks.api.users.register

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApi {
    @POST("register")
    fun register(
        @Body registerRequest : RegisterRequest
    ) : Call<RegisterResponse>
}