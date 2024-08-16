package com.tor.simple_back_seat.ui.ontrip

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OnTripViewModel: ViewModel() {

    private val _menu = MutableStateFlow(ID_ROUTE)
    val menu = _menu.asStateFlow()

    fun setMenu(value: Int) {
        viewModelScope.launch {
            _menu.emit(value)
        }
    }

    companion object {
        const val ID_QRIS = 0
        const val ID_EZ_POINT = 1
        const val ID_ROUTE = 2
        const val ID_ADS = 3
    }
}