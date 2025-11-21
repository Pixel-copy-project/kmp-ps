package org.example.project.viewmodel

import org.example.project.utill.DisplayGoodsItem

data class GoodsUiState(
    val goodsList: List<DisplayGoodsItem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)