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
        resetProductPage()
        loadProductMainScreen()
    }

    fun loadProductMainScreen(pageSize: Int = 4) {
        viewModelScope.launch(ioDispatcher) {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try{
                val product = repository.getProducts(0, pageSize)
                val productUI = product.map { it.toDisplay() }
                _uiState.update{
                    it.copy(
                        productList = productUI,
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

    fun loadProductNextPage(pageSize: Int = 20){
        println("Start Fetching... Current Page: ${_uiState.value.currentPage}")
        if (_uiState.value.isLoading || !_uiState.value.hasMorePage) return

        viewModelScope.launch(ioDispatcher) {
            println("In ViewModelScope... Current Page: ${_uiState.value.currentPage}")
            _uiState.update { it.copy(isLoading = true, error = null) }
            try{
                println("In TryCatch... Current Page: ${_uiState.value.currentPage}")
                val newProduct = repository
                    .getProducts(_uiState.value.currentPage, pageSize)
                println("Fetching After... Current Page: ${_uiState.value.currentPage}")
                val productUI = newProduct.map { it.toDisplay() }
                _uiState.update{
                    it.copy(
                        productList = it.productList + productUI,
                        currentPage = it.currentPage + 1,
                        isLoading = false,
                        error = null,
                        hasMorePage = newProduct.size == 20
                    )
                }
            }catch(e: Exception){
                _uiState.update { it.copy(isLoading = false, error = e.message) }
                e.printStackTrace()
            }finally {
                println("Finally Current Page: ${_uiState.value.currentPage}")
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
        viewModelScope.launch(ioDispatcher) {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try{
                _uiState.update{
                    it.copy(
                        currentPage = page,
                        isLoading = false,
                        error = null,
                        hasMorePage = true,
                    )
                }
            }catch(e: Exception){
                e.printStackTrace()
                _uiState.update { it.copy(isLoading = false, error = e.message) }
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