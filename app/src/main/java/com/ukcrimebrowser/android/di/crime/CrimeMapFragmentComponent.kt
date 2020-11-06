package com.ukcrimebrowser.android.di.crime

import com.ukcrimebrowser.android.di.scopes.PerFragment
import com.ukcrimebrowser.android.presentation.map.CrimeMapFragment
import dagger.Subcomponent

@Subcomponent
@PerFragment
interface CrimeMapFragmentComponent {

    fun inject(fragment: CrimeMapFragment)
}