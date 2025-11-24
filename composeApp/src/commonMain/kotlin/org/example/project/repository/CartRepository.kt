package org.example.project.repository

import org.example.project.utill.GoodsItem

interface CartRepository {
    suspend fun getCart(): List<GoodsItem>
}