package org.example.project.viewmodel

import org.example.project.utill.PostUI

data class PostListUiState(
    val postList: List<PostUI> = emptyList(),
    val currentPage: Int = 1,
    val hasMorePage: Boolean = true,
    val isLoading: Boolean = false,
    val error: String? = ""
)
