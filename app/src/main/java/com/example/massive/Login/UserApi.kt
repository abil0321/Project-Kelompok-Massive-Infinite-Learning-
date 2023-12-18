package com.example.massive.Login

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("entries")
    fun login(
        @Body userRequest: UserRequest
    ): Call<UserResponse>
}