package org.example.project.viewmodel

import org.example.project.utill.DisplayAddress

data class AddressUiState(
    var addressList: List<DisplayAddress> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)
