package org.example.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.ioDispatcher
import org.example.project.repository.PixelRepository
import org.example.project.utill.DisplayNotice
import org.example.project.utill.Notice

class NoticeViewModel(
    private val repository: PixelRepository = PixelRepository()
): ViewModel() {
    private val _uiState = MutableStateFlow(NoticeUiState(isLoading = true))
    val uiState: StateFlow<NoticeUiState> = _uiState.asStateFlow()

    init{
        loadNotice()
    }

    fun loadNotice(){
        viewModelScope.launch(ioDispatcher) {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try{
                val notice = repository.getNoticeList()
                val displayNotice = notice.map { it.toDisplay() }

                _uiState.update{
                    it.copy(
                        noticeList = displayNotice,
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


fun Notice.toDisplay(): DisplayNotice{
    return DisplayNotice(
        title = this.title,
        writer = this.writer,
        tag = this.tag,
        content = this.content,
        createdAt = this.createdAt,
        category = this.category
    )
}