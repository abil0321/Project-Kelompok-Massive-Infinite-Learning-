package com.example.massive.Login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRequest {
    @SerializedName("API")
    @Expose
    var email:String? = null

    @SerializedName("Category")
    @Expose
    var password: String? = null
}