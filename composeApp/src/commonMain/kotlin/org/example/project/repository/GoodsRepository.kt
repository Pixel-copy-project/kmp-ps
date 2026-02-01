package org.example.project.repository

import org.example.project.utill.Product

interface GoodsRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProductByName(name: String): Product?
}