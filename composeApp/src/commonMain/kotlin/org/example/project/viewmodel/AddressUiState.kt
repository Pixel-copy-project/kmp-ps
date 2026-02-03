package org.example.project.viewmodel

import org.example.project.utill.AddressUI

data class AddressUiState(
    val selectedAddress: AddressUI? = null,
    var addressList: List<AddressUI> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)
