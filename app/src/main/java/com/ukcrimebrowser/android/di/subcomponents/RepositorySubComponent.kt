package com.ukcrimebrowser.android.di.subcomponents

import com.ukcrimebrowser.android.domain.repositories.CrimeRepository
import dagger.Subcomponent

@Subcomponent
interface RepositorySubComponent {

    fun provideCrimeRepository(): CrimeRepository

}