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
import org.example.project.utill.DisplayQuestion
import org.example.project.utill.Question

class QuestionViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(QuestionUiState(isLoading = true))
    val uiState: StateFlow<QuestionUiState> = _uiState.asStateFlow()
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
        loadQuestion()
    }

    fun loadQuestion(){
        viewModelScope.launch(ioDispatcher) {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try{
                val question = repository.getQuestionList()
                val displayQuestion = question.map { it.toDisplay() }

                _uiState.update{
                    it.copy(
                        questionList = displayQuestion,
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

fun Question.toDisplay(): DisplayQuestion{
    return DisplayQuestion(
        title = this.title,
        writer = this.writer,
        tag = this.tag,
        content = this.content,
        createdAt = this.createdAt,
        category = this.category,
        goodsName = this.goodsName
    )
}