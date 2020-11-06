package com.ukcrimebrowser.android.domain.executors

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchedulerProvider @Inject constructor() :
    ThreadExecutorProvider {


    override fun ioScheduler(): Scheduler {
        return Schedulers.io()
    }

    override fun computationScheduler(): Scheduler {
        return Schedulers.computation()
    }

    override fun trampoline(): Scheduler {
        return Schedulers.trampoline()
    }
}
