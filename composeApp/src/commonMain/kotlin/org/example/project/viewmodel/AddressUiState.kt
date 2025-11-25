package org.example.project.viewmodel

import org.example.project.utill.DisplayAddress

data class AddressUiState(
    val selectedAddress: DisplayAddress? = null,
    var addressList: List<DisplayAddress> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)
