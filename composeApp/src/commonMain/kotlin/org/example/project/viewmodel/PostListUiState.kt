package org.example.project.viewmodel

import org.example.project.utill.PostUI

data class PostListUiState(
    val postList: List<PostUI> = emptyList(),
    val newPostList: List<PostUI> = emptyList(),
    val currentPage: Int = 0,
    val totalCount: Int = 0,
    val hasMorePage: Boolean = true,
    val isLoading: Boolean = false,
    val error: String? = ""
)
