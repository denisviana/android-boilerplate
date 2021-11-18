package com.app.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.breefjobs.data.helper.FirebaseAuthExceptionHelper

abstract class BaseViewModel<S, C> : ViewModel() {

    private var firebaseAuthExceptionHelper = FirebaseAuthExceptionHelper()

    val command = SingleLiveEvent<C>()
    val state = MutableLiveData<S>()

    protected fun newState(state: S) {
        this.state.value = state
        onNewState(state)
    }

    protected open fun onNewState(state: S) {}

    protected inline fun withState(stateBlock: S.() -> Unit) {
        stateBlock(currentState())
    }

    protected inline fun newState(stateBlock: S.() -> S) {
        newState(stateBlock(currentState()))
    }

    fun currentState(): S {
        return state.value!!
    }

    fun getFirebaseExceptionResult(any: Any): Int =
        firebaseAuthExceptionHelper.handleAuthException(any)

    fun setFirebaseExceptionHelper(firebaseAuthExceptionHelper: FirebaseAuthExceptionHelper) {
        this.firebaseAuthExceptionHelper = firebaseAuthExceptionHelper
    }
}