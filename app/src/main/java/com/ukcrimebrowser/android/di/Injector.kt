package com.ukcrimebrowser.android.di

import com.ukcrimebrowser.android.di.crime.CrimeMapActivityComponent
import com.ukcrimebrowser.android.di.crime.DaggerCrimeMapActivityComponent
import com.ukcrimebrowser.android.presentation.crime.CrimeMapActivity
import com.ukcrimebrowser.android.presentation.mainSubComponent
import com.ukcrimebrowser.android.presentation.map.CrimeMapFragment

object Injector {

    private var crimeMapActivityComponent: CrimeMapActivityComponent? = null

    fun inject(activity: CrimeMapActivity) {
        crimeMapActivityComponent = DaggerCrimeMapActivityComponent.builder()
            .mainSubComponent(activity.mainSubComponent())
            .mainActivity(activity)
            .build()

        crimeMapActivityComponent?.inject(activity)
    }

    fun inject(fragment: CrimeMapFragment) {
        crimeMapActivityComponent?.crimeMapFragmentComponent()?.inject(fragment)
    }

}