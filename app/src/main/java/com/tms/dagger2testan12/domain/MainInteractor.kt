package com.tms.dagger2testan12.domain

import androidx.core.text.isDigitsOnly

interface MainInteractor {
    fun getData(): List<Int>
}

class MainInteractorImpl(private val repository: MainRepository) : MainInteractor {
    override fun getData(): List<Int> {
        return repository.getData()
            .filter { it.isDigitsOnly() }
            .map { it.toInt() }
    }
}