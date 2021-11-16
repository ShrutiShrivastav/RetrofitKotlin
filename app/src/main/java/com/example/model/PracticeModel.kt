package com.example.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class PracticeModel {
    @SerializedName("userWheel")
    @Expose
    var userWheel: List<UserWheel>? = null

}

class UserWheel {
    @SerializedName("_id")
    @Expose
    var id: String? = null

    @SerializedName("user")
    @Expose
    var user: String? = null

    @SerializedName("mood")
    @Expose
    var mood: String? = null
}