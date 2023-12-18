package com.example.massive.Login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse {
    @SerializedName("entries")
    @Expose
    var data:User? = null

    class User{
        @SerializedName("API")
        @Expose
        var email:String? = null

        @SerializedName("Description")
        @Expose
        var name:String? = null

        @SerializedName("token")
        @Expose
        var token:String? = null
    }
}