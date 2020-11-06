package com.ukcrimebrowser.android.di.subcomponents

import com.ukcrimebrowser.android.data.source.contract.CrimeStore
import dagger.Subcomponent

@Subcomponent
interface DataStoreSubComponent {
    fun provideCrimeStore(): CrimeStore
}