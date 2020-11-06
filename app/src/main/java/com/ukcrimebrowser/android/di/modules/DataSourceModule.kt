package com.ukcrimebrowser.android.di.modules

import com.ukcrimebrowser.android.data.source.contract.CrimeStore
import com.ukcrimebrowser.android.data.source.remote.WSCrimeStore
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindCrimeStore(store: WSCrimeStore): CrimeStore
}