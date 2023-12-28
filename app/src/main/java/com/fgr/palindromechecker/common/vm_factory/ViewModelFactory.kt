package com.fgr.palindromechecker.common.vm_factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fgr.palindromechecker.common.di.Injection
import com.fgr.palindromechecker.feature.third.ThirdViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ThirdViewModel::class.java) -> {
                ThirdViewModel(Injection.provideRepository()) as T
            }

            else -> {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}