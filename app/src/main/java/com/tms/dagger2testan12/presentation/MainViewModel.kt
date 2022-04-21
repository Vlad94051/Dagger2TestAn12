package com.tms.dagger2testan12.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tms.dagger2testan12.R
import com.tms.dagger2testan12.domain.MainInteractor
import com.tms.dagger2testan12.utills.ResourceProvider
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val interactor: MainInteractor,
    private val resourceProvider: ResourceProvider
) : ViewModel() {

    private val _numbers = MutableLiveData<List<String>>()
    val numbers: LiveData<List<String>> get() = _numbers

    init {
        initStringsFlow()
    }

    private fun initStringsFlow() {
        interactor.getData() // получили все данные
            .map { _numbers.postValue(it) } // асинхронно отправили в LiveData, тк хз в каком там треде все это выполнялось
            .launchIn(viewModelScope) // подписались на flow внутри viewModelScope (смотри реализацию launchIn)
    }

    fun onButtonClicked() {
        interactor.addIntValue()
    }

    fun getString(): String {
        return resourceProvider.getString(R.string.app_name)
    }
}