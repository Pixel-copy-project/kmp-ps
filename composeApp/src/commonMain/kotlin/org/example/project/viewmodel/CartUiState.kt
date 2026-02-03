package org.example.project.viewmodel

import org.example.project.utill.CartUI

data class CartUiState(
    val items: List<CartUI> = emptyList(),
    val totalPrice: Int = 0,
    val checkedItemsCount: Int = 0,
    val finalOrderList: List<CartUI> = emptyList(),
    val finalOrderTotalPrice: Int = 0
)
