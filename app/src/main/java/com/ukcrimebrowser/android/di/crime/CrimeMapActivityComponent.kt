package com.ukcrimebrowser.android.di.crime

import com.ukcrimebrowser.android.di.BaseComponent
import com.ukcrimebrowser.android.di.subcomponents.MainSubComponent
import com.ukcrimebrowser.android.di.scopes.PerActivity
import com.ukcrimebrowser.android.presentation.crime.CrimeMapActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [CrimeActivityModule::class],
    dependencies = [MainSubComponent::class]
)
@PerActivity
interface CrimeMapActivityComponent : BaseComponent<CrimeMapActivity> {

    fun crimeMapFragmentComponent(): CrimeMapFragmentComponent

    @Component.Builder
    interface Builder {
        fun mainSubComponent(module: MainSubComponent): Builder

        @BindsInstance
        fun mainActivity(activity: CrimeMapActivity): Builder

        fun build(): CrimeMapActivityComponent
    }
}