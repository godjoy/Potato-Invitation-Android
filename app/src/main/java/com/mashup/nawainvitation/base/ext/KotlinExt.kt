package com.mashup.nawainvitation.base.ext

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mashup.nawainvitation.base.ext.dialog.AlertBuilder
import com.mashup.nawainvitation.base.ext.dialog.AndroidAlertBuilder
import com.mashup.nawainvitation.custom.NetworkErrorDialog

const val TAG_DIALOG_ERROR = "tag_dialog_error"

inline fun <A, B, R> ifNotNull(a: A?, b: B?, code: (A, B) -> R) {
    if (a != null && b != null) {
        code(a, b)
    }
}

inline fun <A, B, C, R> ifNotNull(a: A?, b: B?, c: C?, code: (A, B, C) -> R) {
    if (a != null && b != null && c != null) {
        code(a, b, c)
    }
}

fun Context.toast(message: CharSequence): Toast = Toast
    .makeText(this, message, Toast.LENGTH_SHORT)
    .apply {
        show()
    }

fun Context.toast(@StringRes message: Int): Toast = Toast
    .makeText(this, message, Toast.LENGTH_SHORT)
    .apply {
        show()
    }

fun Context.longToast(message: CharSequence): Toast = Toast
    .makeText(this, message, Toast.LENGTH_LONG)
    .apply {
        show()
    }

fun Context.longToast(@StringRes message: Int): Toast = Toast
    .makeText(this, message, Toast.LENGTH_LONG)
    .apply {
        show()
    }

fun Context.alert(
    title: CharSequence? = null,
    message: CharSequence? = null,
    init: (AlertBuilder<DialogInterface>.() -> Unit)? = null
): AlertBuilder<AlertDialog> {
    return AndroidAlertBuilder(this).apply {
        if (title != null) {
            this.title = title
        }
        if (message != null) {
            this.message = message
        }
        if (init != null) init()
    }
}

fun Fragment.showNetworkErrorDialog() {
    NetworkErrorDialog().show(parentFragmentManager, TAG_DIALOG_ERROR)
}

fun AppCompatActivity.showNetworkErrorDialog() {
    NetworkErrorDialog().show(supportFragmentManager, TAG_DIALOG_ERROR)
}

