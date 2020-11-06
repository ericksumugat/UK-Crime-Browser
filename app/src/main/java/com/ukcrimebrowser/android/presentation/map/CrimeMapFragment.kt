package com.ukcrimebrowser.android.presentation.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.SupportMapFragment
import com.ukcrimebrowser.android.presentation.view.TouchableWrapper


class CrimeMapFragment : SupportMapFragment() {
    private var mOriginalContentView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mOriginalContentView = super.onCreateView(inflater, parent, savedInstanceState)

        var mTouchView: TouchableWrapper? = null

        activity?.let {
            val updateMapAfterUserInteraction = if (activity is TouchableWrapper.UpdateMapAfterUserInteraction) activity as (TouchableWrapper.UpdateMapAfterUserInteraction) else null
            mTouchView = TouchableWrapper(it, updateMapAfterUserInteraction)
        }

        mTouchView?.addView(mOriginalContentView)

        return mTouchView
    }

    override fun getView(): View? {
        return mOriginalContentView
    }
}