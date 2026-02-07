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

class ProductViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(ProductUiState(isLoading = true))
    val uiState: StateFlow<ProductUiState> = _uiState.asStateFlow()

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
        loadProductMainScreen()
    }

    fun loadProductMainScreen(pageSize: Int = 4) {
        viewModelScope.launch(ioDispatcher) {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                val product = repository.getProducts(0, pageSize)
                val productUI = product.map { it.toDisplay() }
                _uiState.update {
                    it.copy(
                        productList = productUI,
                        isLoading = false,
                        error = null,
                        currentPage = 1, // 페이지 초기화
                        hasMorePage = product.size >= pageSize
                    )
                }
            } catch(e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
                e.printStackTrace()
            }
        }
    }

    fun loadProductNextPage(pageSize: Int = 20){
        // 중복 호출 방지 강화
        if (_uiState.value.isLoading || !_uiState.value.hasMorePage) {
            println("Skipped - isLoading: ${_uiState.value.isLoading}, hasMorePage: ${_uiState.value.hasMorePage}")
            return
        }

        viewModelScope.launch(ioDispatcher) {
            // 즉시 로딩 상태로 변경하여 중복 호출 방지
            _uiState.update { it.copy(isLoading = true) }

            try{
                val newProduct = repository
                    .getProducts(_uiState.value.currentPage, pageSize)

                val productUI = newProduct.map { it.toDisplay() }

                _uiState.update{
                    it.copy(
                        productList = it.productList + productUI,
                        currentPage = it.currentPage + 1,
                        isLoading = false,
                        error = null,
                        hasMorePage = newProduct.size >= pageSize // >= 로 변경
                    )
                }
            } catch(e: Exception){
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message
                    )
                }
                e.printStackTrace()
            }
        }
    }

    private fun loadProduct(){
        viewModelScope.launch(ioDispatcher) {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try{
                val goods = repository.getProducts()
                val displayGoods = goods.map { it.toDisplay() }

                _uiState.update{
                    it.copy(
                        productList = displayGoods,
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

    fun resetProductPage(page: Int = 1){
        _uiState.update {
            it.copy(
                currentPage = page,
                isLoading = false,
                error = null,
                hasMorePage = true,
            )
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