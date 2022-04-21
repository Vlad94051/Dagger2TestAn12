package com.tms.dagger2testan12.domain.di

import com.tms.dagger2testan12.data.MainRepositoryImpl
import com.tms.dagger2testan12.data.StringStorage
import com.tms.dagger2testan12.domain.MainInteractor
import com.tms.dagger2testan12.domain.MainInteractorImpl
import com.tms.dagger2testan12.domain.MainRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideMainRepository(
        stringStorage: StringStorage
    ): MainRepository {
        return MainRepositoryImpl(stringStorage)
    }

    @Provides
    fun provideInteractor(
        repository: MainRepository
    ): MainInteractor {
        return MainInteractorImpl(repository)
    }
}