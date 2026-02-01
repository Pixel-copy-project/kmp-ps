package org.example.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.example.project.ioDispatcher
import org.example.project.repository.PixelRepository
import org.example.project.utill.Address
import org.example.project.utill.DisplayAddress

class AddressViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(AddressUiState(isLoading = true))
    val uiState: StateFlow<AddressUiState> = _uiState.asStateFlow()
    private val repository = PixelRepository(
        HttpClient{
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    )

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

    fun selectAddress(address: DisplayAddress){
        _uiState.update { it.copy(selectedAddress = address) }
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