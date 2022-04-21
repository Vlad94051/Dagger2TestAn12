package com.tms.dagger2testan12.data

import javax.inject.Inject

class StringStorageImpl @Inject constructor() : StringStorage {
    override fun getData(): List<String> {
        return listOf("Hello Dagger2:", "1", "2", "3", "4")
    }
}