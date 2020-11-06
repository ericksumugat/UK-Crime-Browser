package com.ukcrimebrowser.android.presentation

import android.app.Activity
import android.app.Application
import android.content.Context
import com.ukcrimebrowser.android.di.CoreComponent
import com.ukcrimebrowser.android.di.DaggerCoreComponent

class UkCrimeBrowserApplication: Application() {

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as UkCrimeBrowserApplication).coreComponent
    }

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.builder()
            .application(this)
            .context(this)
            .build()
    }
}


fun Activity.mainSubComponent() = UkCrimeBrowserApplication.coreComponent(
    this
).mainSubComponentBuilder().build()