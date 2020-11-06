package com.ukcrimebrowser.android.di.modules

import com.ukcrimebrowser.android.domain.executors.PostExecutionThread
import com.ukcrimebrowser.android.domain.executors.SchedulerProvider
import com.ukcrimebrowser.android.domain.executors.ThreadExecutorProvider
import com.ukcrimebrowser.android.domain.executors.UIThread
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ThreadProviderModule {

    @Binds
    @Singleton
    abstract fun bindThreadExecutorProvider(schedulerProvider: SchedulerProvider): ThreadExecutorProvider

    @Binds
    @Singleton
    abstract fun bindPostExecutionThread(uiThread: UIThread): PostExecutionThread
}