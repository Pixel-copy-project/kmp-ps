package org.example.project.viewmodel

import org.example.project.utill.ProductUI

data class GoodsUiState(
    val goodsList: List<ProductUI> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)