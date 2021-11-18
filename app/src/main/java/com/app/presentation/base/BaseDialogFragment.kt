package com.app.presentation.base

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

open class BaseDialogFragment : DialogFragment() {

    protected open fun isFullScreen() = true

    protected open fun isDefaultSystemBarDark() = true

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }
}