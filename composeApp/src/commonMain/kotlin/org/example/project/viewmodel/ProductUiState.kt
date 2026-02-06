package org.example.project.viewmodel

import org.example.project.utill.ProductUI

data class ProductUiState(
    val productList: List<ProductUI> = emptyList(),
    val currentPage: Int = 0,
    val hasMorePage: Boolean = true,
    val isLoading: Boolean = false,
    val error: String? = null,
)