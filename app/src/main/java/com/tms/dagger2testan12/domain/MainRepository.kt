package com.tms.dagger2testan12.domain

import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getStrings(): Flow<List<String>>

    fun getInts(): Flow<List<Int>>

    fun addIntValue()
}