package org.example.project.viewmodel

import kotlinx.serialization.Serializable

data class FaqUiState(
    val faqList: List<Faq> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@Serializable
data class Faq(
    val id: String,
    val question: String,
    val answer: String,
)


