package org.example.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import io.ktor.utils.io.ioDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.example.project.ioDispatcher
import org.example.project.repository.PixelRepository

class FAQViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FaqUiState())
    val uiState: StateFlow<FaqUiState> = _uiState.asStateFlow()

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
        loadFAQ()
    }

    private fun loadFAQ(){
        viewModelScope.launch(ioDispatcher) {
            _uiState.update { it.copy(isLoading = true) }
            try{
                val faq = repository.getAllFaq()

                _uiState.update {
                    it.copy(
                        faqList = faq,
                        isLoading = false,
                        error = null
                    )
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}