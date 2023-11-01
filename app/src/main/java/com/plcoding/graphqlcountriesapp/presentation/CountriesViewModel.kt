package com.plcoding.graphqlcountriesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.graphqlcountriesapp.domain.model.DetailedCountry
import com.plcoding.graphqlcountriesapp.domain.usecase.GetCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase
): ViewModel() {

    private val _state = MutableStateFlow(CountriesState())
    val state = _state.asStateFlow()



    fun selectCountry(code: String) {
        viewModelScope.launch {
            _state.update { it.copy(
                country  = getCountriesUseCase.execute(code)
            ) }
        }
    }

    fun dismissCountryDialog() {
        _state.update { it.copy(
            country  = null
        ) }
    }

    data class CountriesState(
        val country: DetailedCountry? = null,
        val isLoading: Boolean = false,
    )
}