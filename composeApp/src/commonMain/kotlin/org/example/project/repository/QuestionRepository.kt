package org.example.project.repository

import org.example.project.utill.Question

interface QuestionRepository {
    suspend fun getQuestionList(): List<Question>
    suspend fun getQuestionByTitle(title: String): Question?
}