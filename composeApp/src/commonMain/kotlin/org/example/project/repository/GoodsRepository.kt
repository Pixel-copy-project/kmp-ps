package org.example.project.repository

import org.example.project.utill.GoodsItem

interface GoodsRepository {
    suspend fun getGoodsList(): List<GoodsItem>
    suspend fun getGoodsById(id: Int): GoodsItem?
    suspend fun getGoodsByName(name: String): GoodsItem?
}