package org.example.project.viewmodel

import org.example.project.utill.DisplayQuestion

data class QuestionUiState(
    val questionList: List<DisplayQuestion> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = ""
)
