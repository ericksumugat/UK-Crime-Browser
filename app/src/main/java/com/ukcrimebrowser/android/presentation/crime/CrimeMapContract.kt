package com.ukcrimebrowser.android.presentation.crime

import com.ukcrimebrowser.android.presentation.base.BasePresenter

interface CrimeMapContract {
    interface View {
        fun showCrimes(crimeDetails: List<CrimeDetail>, reset: Boolean = false)
    }

    interface ActionListener : BasePresenter<View> {

        fun getCrimes(date: String, latitude: Double, longitude: Double)
        fun updateDate(date: String)
    }
}