package com.tms.dagger2testan12

import android.content.Context
import com.tms.dagger2testan12.data.di.DataModule
import com.tms.dagger2testan12.domain.di.DomainModule
import com.tms.dagger2testan12.presentation.MainActivity
import com.tms.dagger2testan12.utills.di.UtilsModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DomainModule::class,
        DataModule::class,
        UtilsModule::class
    ]
)
interface AppComponent {
    fun inject(target: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun buildContext(context: Context): Builder

        fun build(): AppComponent
    }
}