package org.example.project.repository

import org.example.project.utill.Product

interface CartRepository {
    suspend fun getCart(): List<Product>
}