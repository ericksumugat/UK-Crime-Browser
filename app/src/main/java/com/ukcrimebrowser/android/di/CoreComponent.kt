package com.ukcrimebrowser.android.di

import android.app.Application
import android.content.Context
import com.ukcrimebrowser.android.di.modules.DataSourceModule
import com.ukcrimebrowser.android.di.modules.NetworkModule
import com.ukcrimebrowser.android.di.modules.RepositoriesModule
import com.ukcrimebrowser.android.di.modules.ThreadProviderModule
import com.ukcrimebrowser.android.di.subcomponents.MainSubComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        NetworkModule::class,
        DataSourceModule::class,
        RepositoriesModule::class,
        ThreadProviderModule::class
    ]
)
@Singleton
interface CoreComponent {

    fun mainSubComponentBuilder(): MainSubComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): CoreComponent
    }
}