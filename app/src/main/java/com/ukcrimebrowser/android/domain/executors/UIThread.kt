package com.ukcrimebrowser.android.domain.executors

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * MainThread (UI Thread) implementation based on a [ which will execute actions on the Android UI thread][io.reactivex.Scheduler]
 */
@Singleton
class UIThread @Inject
constructor() : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}