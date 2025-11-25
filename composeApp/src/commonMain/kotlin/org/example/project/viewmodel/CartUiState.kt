package org.example.project.viewmodel

import org.example.project.utill.DisplayGoodsItem

data class CartUiState(
    val cart: MutableList<DisplayGoodsItem> = mutableListOf(),
    val finalOrderList: MutableList<DisplayGoodsItem> = mutableListOf(),
    val totalPrice: Int = 0,
    val isLoading: Boolean = false,
    val error: String? = null,
)
