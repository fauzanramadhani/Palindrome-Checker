package com.fgr.palindromechecker.data.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<out T: Any?>(

    @field:SerializedName("per_page")
    val perPage: Int,

    @field:SerializedName("total")
    val total: Int,

    @field:SerializedName("data")
    val data: T,

    @field:SerializedName("page")
    val page: Int,

    @field:SerializedName("total_pages")
    val totalPages: Int,

    @field:SerializedName("support")
    val supportResponse: SupportResponse
)
