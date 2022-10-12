package com.example.kts_template.ui.mainscreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor() : ViewModel() {

    private var mutableState = MutableStateFlow(MainScreenState(1))
    val state: StateFlow<MainScreenState> = mutableState

    fun eventHandler(event: MainScreenEvent) {
        when (event) {
            MainScreenEvent.IncrementInt -> {
                mutableState.value = mutableState.value.copy(
                    int = mutableState.value.int + 1
                )
            }
        }
    }
}