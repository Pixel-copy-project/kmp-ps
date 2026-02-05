package org.example.project.repository

import org.example.project.utill.Post
import org.example.project.utill.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProducts(page: Int, pageSize: Int): List<Product>
    suspend fun getProductByName(name: String): Product?
}