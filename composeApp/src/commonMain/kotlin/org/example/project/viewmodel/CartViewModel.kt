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
import org.example.project.utill.DisplayGoodsItem

class CartViewModel(
    private val repository: PixelRepository = PixelRepository()
): ViewModel() {
    private val _uiState = MutableStateFlow(CartUiState(isLoading = true))
    val uiState: StateFlow<CartUiState> = _uiState.asStateFlow()

    init{
        loadCart()
    }

    private fun loadCart(){
        viewModelScope.launch(ioDispatcher) {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try{
                val cart = repository.getCart()
                val displayGoods = cart.map { it.toDisplay() }.toMutableList()

                _uiState.update{
                    it.copy(
                        cart = displayGoods,
                        finalOrderList = displayGoods.toMutableList(),
                        totalPrice = displayGoods.sumOf { item -> item.price },
                        isLoading = false,
                        error = null,
                    )
                }
            }catch(e: Exception){
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
    fun addItem(item: DisplayGoodsItem){
        _uiState.update{
            it.copy(
                cart = it.cart.apply { add(item) },
                finalOrderList = it.finalOrderList.apply { add(item) }
            )
        }
    }

    fun removeItem(item: DisplayGoodsItem){
        _uiState.update{
            it.copy(
                cart = it.cart.apply { remove(item) },
                finalOrderList = it.finalOrderList.apply { remove(item) }
            )
        }
    }
    fun addFinalItem(item: DisplayGoodsItem){
        _uiState.update{
            val cart = it.finalOrderList
            cart.add(item)
            it.copy(
                finalOrderList = cart,
                totalPrice = cart.sumOf { item -> item.price }
            )
        }
    }

    fun removeFinalItem(item: DisplayGoodsItem){
        _uiState.update{
            val cart = it.finalOrderList
            cart.remove(item)
            it.copy(
                finalOrderList = cart,
                totalPrice = cart.sumOf { item -> item.price }
            )
        }
    }

    fun getByName(name: String){
    }
}