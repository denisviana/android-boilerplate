package com.app.presentation.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty0

abstract class BaseViewModelFragment : Fragment(), ViewDiffContainer {

    override val updated: HashMap<String, Any?> = HashMap()

    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onDestroyView() {
        super.onDestroyView()
        updated.clear()
    }

    protected inline infix fun <reified R> KProperty0<R>.partTo(noinline renderer: (R) -> Unit) {
        val func = renderer as KFunction<*>
        val named = "${this.name}:${func.name}"
        part(named, this.get(), renderer)
    }

    protected inline fun <T, VM : BaseViewModel<T, *>> VM.bind(crossinline state: T.() -> Unit) {
        this.state.observe(this@BaseViewModelFragment, Observer {
            if (it != null) {
                state(it)
            }
        })
    }

    protected inline fun <T, VM : BaseViewModel<*, T>> VM.listen(crossinline command: T.() -> Unit) {
        this.command.observe(this@BaseViewModelFragment, Observer {
            if (it != null) {
                command(it)
            }
        })
    }
}