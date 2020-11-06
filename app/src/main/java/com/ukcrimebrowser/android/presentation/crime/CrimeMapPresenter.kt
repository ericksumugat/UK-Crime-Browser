package com.ukcrimebrowser.android.presentation.crime

import com.ukcrimebrowser.android.domain.executors.PostExecutionThread
import com.ukcrimebrowser.android.domain.executors.ThreadExecutorProvider
import com.ukcrimebrowser.android.domain.usecases.CrimeProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CrimeMapPresenter @Inject constructor(
    private val crimeProvider: CrimeProvider,
    private val threadExecutorProvider: ThreadExecutorProvider,
    private val postExecutionThread: PostExecutionThread
) :
    CrimeMapContract.ActionListener {

    private lateinit var view: CrimeMapContract.View
    private val compositeDisposable = CompositeDisposable()

    private var date: String = ""
    private var latitude: Double = 51.509865
    private var longitude: Double = -0.118092
    private var dateChanged = false

    override fun setView(view: CrimeMapContract.View) {
        this.view = view
    }

    override fun start() {
    }

    override fun destroy() {

    }

    override fun resume() {

    }

    override fun pause() {

    }

    override fun updateDate(date: String){
        dateChanged = !this.date.equals(date,true)

        this.date = date
        getCrimes(date, latitude, longitude)
    }

    override fun getCrimes(date: String, latitude: Double, longitude: Double) {
        this.date = date
        this.latitude = latitude
        this.longitude = longitude

        compositeDisposable.add(crimeProvider.getCrimesByAngles(date, latitude, longitude)
            .subscribeOn(threadExecutorProvider.computationScheduler())
            .observeOn(postExecutionThread.scheduler)
            .subscribe({
                view.showCrimes(it, dateChanged)
                dateChanged = false
            }, {
                it.printStackTrace()
            }))
    }
}