package com.ukcrimebrowser.android.di.subcomponents

import android.app.Application
import dagger.Subcomponent

@Subcomponent
interface MainSubComponent :
    RepositorySubComponent,
    DataStoreSubComponent,
    ThreadProviderSubComponent {

    fun provideApplication(): Application

    @Subcomponent.Builder
    interface Builder {
        fun build(): MainSubComponent
    }
}