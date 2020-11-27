package com.aaebrahimian.vaxino.recyclerview


import com.google.gson.annotations.SerializedName

data class Post_ModelItem(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)