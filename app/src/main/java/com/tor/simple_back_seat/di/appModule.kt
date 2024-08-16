package com.tor.simple_back_seat.di


import com.tor.simple_back_seat.ui.ontrip.OnTripViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { OnTripViewModel() }
}
