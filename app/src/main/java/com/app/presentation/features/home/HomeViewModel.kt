package com.app.presentation.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class HomeUiState {
    object ShowScanLoading : HomeUiState()
    object ShowSearchButton : HomeUiState()
    object ShowDevicesList : HomeUiState()
}

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel(){

    val state = MutableStateFlow<HomeUiState>(HomeUiState.ShowSearchButton)

    fun onSearchDevicesPressed(){
        viewModelScope.launch {
            state.value = HomeUiState.ShowScanLoading
            delay(3000)
            state.value = HomeUiState.ShowDevicesList
        }
    }

}

data class HomeState(
    val loading: Boolean = false
)

sealed class HomeCommand