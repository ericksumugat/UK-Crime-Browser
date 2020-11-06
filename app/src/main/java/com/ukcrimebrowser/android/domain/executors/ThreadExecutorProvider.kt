package com.ukcrimebrowser.android.domain.executors

import com.englishcentral.android.core.lib.domain.executors.ThreadExecutor
import io.reactivex.Scheduler

interface ThreadExecutorProvider {

    fun ioScheduler(): Scheduler

    fun computationScheduler(): Scheduler

    fun trampoline(): Scheduler
}
