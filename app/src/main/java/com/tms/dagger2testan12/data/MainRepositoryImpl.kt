package com.tms.dagger2testan12.data

import com.tms.dagger2testan12.domain.MainRepository

class MainRepositoryImpl(private val storage: StringStorage) : MainRepository {
    override fun getData(): List<String> {
        return storage.getData()
    }
}