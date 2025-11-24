package org.example.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.ioDispatcher
import org.example.project.repository.PixelRepository
import org.example.project.utill.Address
import org.example.project.utill.DisplayAddress

class AddressViewModel(
    private val repository: PixelRepository = PixelRepository()
): ViewModel() {
    private val _uiState = MutableStateFlow(AddressUiState(isLoading = true))
    val uiState: StateFlow<AddressUiState> = _uiState.asStateFlow()

    init{
        loadAddress()
    }

    private fun loadAddress(){
        viewModelScope.launch(ioDispatcher) {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try{
                val address = repository.getAddressList()
                val displayAddress = address.map { it.toDisplay() }

                _uiState.update{
                    it.copy(
                        addressList = displayAddress,
                        isLoading = false,
                        error = null,
                    )
                }
            }catch(e: Exception){
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
    fun addAddress(newAddress: DisplayAddress) {
        _uiState.update { currentState ->
            currentState.copy(
                addressList = currentState.addressList + newAddress
            )
        }
    }
}

fun Address.toDisplay(): DisplayAddress {
    return DisplayAddress(
        addressName = this.addressName,
        addressDetail = this.addressDetail,
        addressRoad = this.addressRoad,
        addressZipCode = this.addressZipCode,
    )
}