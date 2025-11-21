package org.example.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.repository.PixelRepository
import org.example.project.utill.DisplayGoodsItem
import org.example.project.utill.GoodsItem

class GoodsViewModel(
    private val repository: PixelRepository = PixelRepository()
): ViewModel() {
    private val _uiState = MutableStateFlow(GoodsUiState(isLoading = true))
    val uiState: StateFlow<GoodsUiState> = _uiState.asStateFlow()

    init{
        loadGoods()
    }

    fun loadGoods(){
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try{
                val goods = repository.getGoodsList()
                val displayGoods = goods.map { it.toDisplay() }

                _uiState.update{
                    it.copy(
                        goodsList = displayGoods,
                        isLoading = false,
                        error = null,
                    )
                }
            }catch(e: Exception){
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}

fun GoodsItem.toDisplay(): DisplayGoodsItem{
    return DisplayGoodsItem(
        id = this.id,
        name = this.name,
        description = this.description,
        price = this.price,
        imageRes = this.imageRes,
        quantity = this.quantity
    )
}