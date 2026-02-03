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
import org.example.project.utill.PostUI
import org.example.project.utill.Post

class PostViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(PostUiState(isLoading = true))
    val uiState: StateFlow<PostUiState> = _uiState.asStateFlow()
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
        loadPost()
    }

    fun loadPost(){
        viewModelScope.launch(ioDispatcher) {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try{
                val posts = repository.getPost()
                val postsUi = posts.map { it.toDisplay() }

                _uiState.update{
                    it.copy(
                        postList = postsUi,
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

fun Post.toDisplay(): PostUI{
    return PostUI(
        title = this.title,
        author = this.author,
        tag = this.tag,
        content = this.content,
        createdAt = this.createdAt,
        category = this.category,
    )
}