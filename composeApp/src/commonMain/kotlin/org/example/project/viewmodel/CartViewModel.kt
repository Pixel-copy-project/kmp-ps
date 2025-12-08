package org.example.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.ioDispatcher
import org.example.project.repository.PixelRepository
import org.example.project.utill.DisplayCartItem
import org.example.project.utill.DisplayGoodsItem

class CartViewModel(
    private val repository: PixelRepository = PixelRepository()
): ViewModel() {
    private val _uiState = MutableStateFlow(CartUiState())
    val uiState: StateFlow<CartUiState> = _uiState.asStateFlow()

    init {
        loadCartItems()
    }

    private fun loadCartItems() {
        val sampleItems = listOf(
            DisplayCartItem("무선 이어폰", 89000, 1, description = "11ffwqg", true),
            DisplayCartItem("노트북 거치대", 35000, 2, description = "11ffwqg", true),
            DisplayCartItem("USB-C 케이블", 12000, 3,  description = "11ffwqg",true)
        )
        _uiState.update {
            it.copy(items = sampleItems)
        }
        calculateTotals()
    }

    fun toggleItemCheck(itemName: String) {
        _uiState.update { state ->
            state.copy(
                items = state.items.map { item ->
                    if (item.name == itemName) {
                        item.copy(isChecked = !item.isChecked)
                    } else {
                        item
                    }
                }
            )
        }
        calculateTotals()
    }

    fun toggleAllItems() {
        val allChecked = _uiState.value.items.all { it.isChecked }
        _uiState.update { state ->
            state.copy(
                items = state.items.map { it.copy(isChecked = !allChecked) }
            )
        }
        calculateTotals()
    }

    fun updateQuantity(itemName: String, newQuantity: Int) {
        if (newQuantity <= 0) return

        _uiState.update { state ->
            state.copy(
                items = state.items.map { item ->
                    if (item.name == itemName) {
                        item.copy(quantity = newQuantity)
                    } else {
                        item
                    }
                }
            )
        }
        calculateTotals()
    }

    fun removeItem(itemName: String) {
        _uiState.update { state ->
            state.copy(
                items = state.items.filter { it.name != itemName }
            )
        }
        calculateTotals()
    }

    fun removeCheckedItems() {
        _uiState.update { state ->
            state.copy(
                items = state.items.filter { !it.isChecked }
            )
        }
        calculateTotals()
    }

    fun updateFinalOrderList(){

    }

    private fun calculateTotals() {
        _uiState.update { state ->
            val checkedItems = state.items.filter { it.isChecked }
            val total = checkedItems.sumOf { it.price * it.quantity }
            state.copy(
                totalPrice = total,
                checkedItemsCount = checkedItems.size
            )
        }
    }
}