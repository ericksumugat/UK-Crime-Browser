package com.ukcrimebrowser.android.presentation.view

import android.content.Context
import android.os.SystemClock
import android.view.MotionEvent
import android.widget.FrameLayout

class TouchableWrapper(
    context: Context,
    private val updateMapAfterUserInteraction: UpdateMapAfterUserInteraction?
) : FrameLayout(context) {

    companion object {
        private const val SCROLL_TIME =
            200L // 200 Milliseconds, but you can adjust that to your liking
    }

    private var lastTouched: Long = 0

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> lastTouched = SystemClock.uptimeMillis()
            MotionEvent.ACTION_UP -> {
                val now = SystemClock.uptimeMillis()
                if (now - lastTouched > SCROLL_TIME) {
                    // Update the map
                    updateMapAfterUserInteraction?.onUpdateMapAfterUserInteraction()
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    // Map Activity must implement this interface
    interface UpdateMapAfterUserInteraction {
        fun onUpdateMapAfterUserInteraction()
    }


}