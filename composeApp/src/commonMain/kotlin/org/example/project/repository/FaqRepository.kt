package org.example.project.repository

import org.example.project.viewmodel.Faq

interface FaqRepository {
    suspend fun getAllFaq(): List<Faq>
    /*suspend fun addFaq(faq: FaqCreateRequest): Unit
    suspend fun deleteFaq(id: UUID): Boolean*/
}