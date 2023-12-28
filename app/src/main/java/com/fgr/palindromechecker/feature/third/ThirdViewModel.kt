package com.fgr.palindromechecker.feature.third

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fgr.palindromechecker.data.repository.UserRepository
import com.fgr.palindromechecker.data.response.UserResponse
import kotlinx.coroutines.flow.Flow

class ThirdViewModel(
    userRepository: UserRepository
) : ViewModel() {
    val users: Flow<PagingData<UserResponse>> = userRepository.getUsers()
        .cachedIn(viewModelScope)
}