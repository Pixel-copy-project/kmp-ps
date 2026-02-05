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
    private val _postListUiState = MutableStateFlow(PostListUiState(isLoading = true))
    val postListUiState: StateFlow<PostListUiState> = _postListUiState.asStateFlow()

    private val _postDetailUiState = MutableStateFlow(PostDetailUiState(isLoading = true))
    val postDetailUiState: StateFlow<PostDetailUiState> = _postDetailUiState.asStateFlow()

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
        loadPostMainScreen(5)
    }

    fun loadPost(){
        viewModelScope.launch(ioDispatcher) {
            _postListUiState.update { it.copy(isLoading = true, error = null) }
            try{
                val posts = repository.getPost()
                println(posts.size)
                val postsUi = posts.map { it.toDisplay() }

                _postListUiState.update{
                    it.copy(
                        postList = postsUi,
                        isLoading = false,
                        error = null,
                    )
                }
            }catch(e: Exception){
                _postListUiState.update { it.copy(isLoading = false, error = e.message) }
                e.printStackTrace()
            }
        }
    }
    fun loadPostMainScreen(pageSize: Int = 4) {
        viewModelScope.launch(ioDispatcher) {
            _postDetailUiState.update { it.copy(isLoading = true, error = null) }
            try{
                val posts = repository.getPost(0, pageSize)
                println(posts.size)
                val postsUi = posts.map { it.toDisplay() }
                _postListUiState.update{
                    it.copy(
                        postList = postsUi,
                        isLoading = false,
                        error = null,
                    )
                }
            }catch(e: Exception){
                _postListUiState.update { it.copy(isLoading = false, error = e.message) }
                e.printStackTrace()
            }
        }
    }

    fun loadPostNextPage(pageSize: Int){
        viewModelScope.launch(ioDispatcher) {
            _postDetailUiState.update { it.copy(isLoading = true, error = null) }
            try{
                val posts = repository
                    .getPost(
                        _postListUiState.value.currentPage,
                        pageSize)

                println(posts.size)
                val postsUi = posts.map { it.toDisplay() }
                _postListUiState.update{
                    it.copy(
                        postList = postsUi,
                        isLoading = false,
                        error = null,
                    )
                }
            }catch(e: Exception){
                _postListUiState.update { it.copy(isLoading = false, error = e.message) }
                e.printStackTrace()
            }
        }
    }

    fun getProductDetail(id: String){
        /*viewModelScope.launch(ioDispatcher) {
            _postListUiState.update { it.copy(isLoading = true) }
            try{
                val post = repository.getPostById(id)
                _postDetailUiState.update{
                    it.copy(
                        postList =
                    )
                }
            }
        }*/
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