package com.ukcrimebrowser.android.di.subcomponents

import com.ukcrimebrowser.android.domain.executors.PostExecutionThread
import com.ukcrimebrowser.android.domain.executors.ThreadExecutorProvider
import dagger.Subcomponent

@Subcomponent
interface ThreadProviderSubComponent {
    fun providePostExecutionThread(): PostExecutionThread

    fun provideThreadExecutorProvider(): ThreadExecutorProvider
}