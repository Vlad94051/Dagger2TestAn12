package com.tms.dagger2testan12.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tms.dagger2testan12.R
import com.tms.dagger2testan12.domain.MainInteractor
import com.tms.dagger2testan12.utills.ResourceProvider
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val interactor: MainInteractor,
    private val resourceProvider: ResourceProvider
) : ViewModel() {

    private val _numbers = MutableLiveData<List<Int>>()
    val numbers: LiveData<List<Int>> get() = _numbers

    init {
        loadNumbers()
    }

    private fun loadNumbers() {
        _numbers.value = interactor.getData()
    }

    fun getString(): String {
        return resourceProvider.getString(R.string.app_name)
    }
}