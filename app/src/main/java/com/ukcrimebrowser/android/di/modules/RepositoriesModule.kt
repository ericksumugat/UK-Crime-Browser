package com.ukcrimebrowser.android.di.modules

import com.ukcrimebrowser.android.data.repositories.CrimeDataRepository
import com.ukcrimebrowser.android.domain.repositories.CrimeRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoriesModule {

    @Singleton
    @Binds
    abstract fun bindCrimeRepository(repository: CrimeDataRepository): CrimeRepository

}