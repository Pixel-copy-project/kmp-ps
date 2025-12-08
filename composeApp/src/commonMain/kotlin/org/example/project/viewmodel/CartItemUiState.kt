package org.example.project.viewmodel

import org.example.project.utill.DisplayCartItem

data class CartUiState(
    val items: List<DisplayCartItem> = emptyList(),
    val totalPrice: Int = 0,
    val checkedItemsCount: Int = 0,
    val finalOrderList: List<DisplayCartItem> = emptyList(),
    val finalOrderTotalPrice: Int = 0
)
