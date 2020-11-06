package com.ukcrimebrowser.android.di.crime

import com.ukcrimebrowser.android.di.scopes.PerActivity
import com.ukcrimebrowser.android.domain.adapters.GoogleMapAdapter
import com.ukcrimebrowser.android.domain.adapters.MapAdapter
import com.ukcrimebrowser.android.domain.usecases.CrimeProvider
import com.ukcrimebrowser.android.domain.usecases.UkCrimeProvider
import com.ukcrimebrowser.android.presentation.crime.CrimeMapContract
import com.ukcrimebrowser.android.presentation.crime.CrimeMapPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class CrimeActivityModule {

    @Binds
    @PerActivity
    abstract fun bindCrimeActivityPresenter(presenter: CrimeMapPresenter): CrimeMapContract.ActionListener

    @Binds
    @PerActivity
    abstract fun bindMapAdapter(adapter: GoogleMapAdapter): MapAdapter

    @Binds
    @PerActivity
    abstract fun bindCrimeProvider(crimeProvider: UkCrimeProvider): CrimeProvider
}