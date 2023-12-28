package com.fgr.palindromechecker.common.di

import com.fgr.palindromechecker.data.config.apiConfig
import com.fgr.palindromechecker.data.remote.UserRemote
import com.fgr.palindromechecker.data.repository.UserRepository

object Injection {
    fun provideRepository(): UserRepository {
        val userRemote = apiConfig().create(UserRemote::class.java)
        return UserRepository(userRemote)
    }
}