package com.tms.dagger2testan12.data.di

import com.tms.dagger2testan12.data.StringStorage
import com.tms.dagger2testan12.data.StringStorageImpl
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideStringStorage(): StringStorage {
        return StringStorageImpl()
    }
}