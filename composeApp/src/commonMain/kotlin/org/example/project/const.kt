package org.example.project

import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.good_4
import kmpproject.composeapp.generated.resources.goods_1
import kmpproject.composeapp.generated.resources.goods_2
import kmpproject.composeapp.generated.resources.goods_3
import org.jetbrains.compose.resources.DrawableResource

data class GoodsItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: Int,
    val imageRes: DrawableResource,
    val quantity: Int
)

val goodsList = listOf(
    GoodsItem(
        id = 1,
        name = "상품 1",
        description = "[예약구매] 11월 9일 일요일 오후 11시까지",
        price = 17000,
        imageRes = Res.drawable.goods_1,
        quantity = 100,
    ),
    GoodsItem(
        id = 2,
        name = "상품 2",
        description = "[예약구매] 11월 9일 일요일 오후 11시까지",
        price = 40000,
        imageRes = Res.drawable.goods_2,
        quantity = 100,
    ),
    GoodsItem(
        id = 3,
        name = "상품 3",
        description = "[예약구매] 11월 9일 일요일 오후 11시까지",
        price = 14000,
        imageRes = Res.drawable.goods_3,
        quantity = 100,
    ),
    GoodsItem(
        id = 4,
        name = "상품 2",
        description = "[예약구매] 11월 9일 일요일 오후 11시까지",
        price = 18500,
        imageRes = Res.drawable.good_4,
        quantity = 0,
    ),
    GoodsItem(
        id = 4,
        name = "상품 2",
        description = "[예약구매] 11월 9일 일요일 오후 11시까지",
        price = 18500,
        imageRes = Res.drawable.good_4,
        quantity = 100,
    ),
    GoodsItem(
        id = 4,
        name = "상품 2",
        description = "[예약구매] 11월 9일 일요일 오후 11시까지",
        price = 18500,
        imageRes = Res.drawable.good_4,
        quantity = 0,
    ),
    GoodsItem(
        id = 4,
        name = "상품 2",
        description = "[예약구매] 11월 9일 일요일 오후 11시까지",
        price = 18500,
        imageRes = Res.drawable.good_4,
        quantity = 100,
    ),
)