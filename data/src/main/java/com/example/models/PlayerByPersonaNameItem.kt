package com.example.models

import com.google.gson.annotations.SerializedName

data class PlayerByPersonaNameItem(
    val accountId: Int,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("avatarfull")
    val avatarFull: String,
    @SerializedName("avatarmedium")
    val avatarMedium: String,
    @SerializedName("cheese")
    val cheese: Int,
    @SerializedName("personaname")
    val personaName: String,
    @SerializedName("plus")
    val plus: Boolean,
    @SerializedName("profileurl")
    val profileUrl: String,
    @SerializedName("steamid")
    val steamId: String
)