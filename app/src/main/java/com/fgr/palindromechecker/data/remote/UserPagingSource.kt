package com.fgr.palindromechecker.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fgr.palindromechecker.data.response.UserResponse

class UserPagingSource(
    private val userRemote: UserRemote
) : PagingSource<Int, UserResponse>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserResponse> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = userRemote.getUsers(nextPageNumber, params.loadSize)
            LoadResult.Page(
                data = response.data.ifEmpty { listOf() },
                prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1,
                nextKey = if (response.data.isEmpty()) null else nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UserResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

