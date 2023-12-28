package com.fgr.palindromechecker.data.remote

import com.fgr.palindromechecker.data.response.BaseResponse
import com.fgr.palindromechecker.data.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserRemote {
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): BaseResponse<List<UserResponse>>
}