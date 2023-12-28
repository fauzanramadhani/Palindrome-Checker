package com.fgr.palindromechecker.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.fgr.palindromechecker.data.remote.UserPagingSource
import com.fgr.palindromechecker.data.remote.UserRemote
import com.fgr.palindromechecker.data.response.UserResponse
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val userRemote: UserRemote,
) {
    fun getUsers(): Flow<PagingData<UserResponse>> {
        return Pager(
            config = PagingConfig(initialLoadSize = 8, pageSize = 8, enablePlaceholders = false),
            pagingSourceFactory = { UserPagingSource(userRemote) }
        ).flow
    }
}