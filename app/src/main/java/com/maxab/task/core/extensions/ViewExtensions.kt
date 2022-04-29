package com.maxab.task.core.extensions

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


typealias InflateFragment<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
typealias InflateActivity<T> = (LayoutInflater) -> T

fun <T : Any?, L : StateFlow<T>> LifecycleOwner.observe(flow: L, body: (T) -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collect {
                body.invoke(it)
            }
        }
    }
}

fun String?.removeWhitespaces(): String = this?.replace(" ", "") ?: ""

fun String?.toSafeDouble(returnValue: Double = 0.0): Double {
    return try {
        if (isNullOrBlank()) returnValue else removeWhitespaces().toDouble()
    } catch (e: NumberFormatException) {
        returnValue
    }
}

fun View.showKeyboard() = (this.context as? Activity)?.showKeyboard()
fun View.hideKeyboard() = (this.context as? Activity)?.hideKeyboard()

fun Fragment.showKeyboard(): Unit? = activity?.let(FragmentActivity::showKeyboard)
fun Fragment.hideKeyboard() = activity?.hideKeyboard()

fun Context.showKeyboard() = (this as? Activity)?.showKeyboard()
fun Context.hideKeyboard() = (this as? Activity)?.hideKeyboard()

fun Activity.showKeyboard() = WindowInsetsControllerCompat(window, window.decorView).show(
    WindowInsetsCompat.Type.ime()
)

fun Activity.hideKeyboard() =
    WindowInsetsControllerCompat(window, window.decorView).hide(WindowInsetsCompat.Type.ime())