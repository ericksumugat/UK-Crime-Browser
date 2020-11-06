package com.ukcrimebrowser.android.presentation.base

interface BasePresenter<V> {

    fun setView(view: V)

    fun start()

    fun destroy()

    fun resume()

    fun pause()
}