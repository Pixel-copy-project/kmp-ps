package org.example.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.example.project.ioDispatcher
import org.example.project.repository.PixelRepository
import org.example.project.utill.ProductUI
import org.example.project.utill.Product

class GoodsViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(GoodsUiState(isLoading = true))
    val uiState: StateFlow<GoodsUiState> = _uiState.asStateFlow()

    private val repository = PixelRepository(
        HttpClient{
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    )

    init{
        loadGoods()
    }

    private fun loadGoods(){
        viewModelScope.launch(ioDispatcher) {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try{
                val goods = repository.getProducts()
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
                e.printStackTrace()
            }
        }
    }
}

fun Product.toDisplay(): ProductUI{
    return ProductUI(
        id = this.id,
        name = this.name,
        description = this.description,
        price = this.price,
        imageName = this.imgName,
        quantity = this.quantity
    )
}