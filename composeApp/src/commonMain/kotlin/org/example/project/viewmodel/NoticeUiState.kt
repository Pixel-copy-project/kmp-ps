package org.example.project.viewmodel

import org.example.project.utill.DisplayNotice

data class NoticeUiState(
    val noticeList: List<DisplayNotice> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)
