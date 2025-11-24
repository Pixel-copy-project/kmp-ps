package org.example.project.viewmodel

import org.example.project.utill.DisplayGoodsItem

data class CartUiState(
    val cart: List<DisplayGoodsItem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)
