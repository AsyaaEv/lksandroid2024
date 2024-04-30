package com.example.lombalks.api.users

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("login")
    fun getDataUser(
        @Body userRequest: UserRequest
    ): Call<UserResponse>
}