package com.fgr.palindromechecker.data.response

import com.google.gson.annotations.SerializedName

data class SupportResponse(

    @field:SerializedName("text")
    val text: String,

    @field:SerializedName("url")
    val url: String
)