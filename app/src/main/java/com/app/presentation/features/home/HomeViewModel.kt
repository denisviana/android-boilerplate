package com.app.presentation.features.home

import com.app.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeState, HomeCommand>(){

    init {
        newState(HomeState())
    }

}

data class HomeState(
    val loading : Boolean = false
)

sealed class HomeCommand