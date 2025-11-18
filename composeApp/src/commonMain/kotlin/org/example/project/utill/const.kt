package org.example.project.utill

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

data class Notice(
    val title: String,
    val writer: String,
    val category: String,
    val content: String,
    val createdAt: String,
)

data class Question(
    val title: String,
    val writer: String,
    val category: String,
    val content: String,
    val createdAt: String,
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

val NoticeList = listOf(
    Notice(
        title = "아구이뽀 맥주컵 굿즈",
        category = "[신규 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "배송 지연 안내",
        category = "[지누 티비 트레이]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = " 나나양 점착메모지/스티커/아크릴 스탠드",
        category = "[신규 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "추가 배송 지연 안내",
        category = "[설백 6주년 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "아구이뽀 맥주컵 굿즈",
        category = "[신규 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "배송 지연 안내",
        category = "[지누 티비 트레이]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "추가 배송 지연 안내",
        category = "[설백 6주년 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "아구이뽀 맥주컵 굿즈",
        category = "[신규 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "배송 지연 안내",
        category = "[지누 티비 트레이]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "배송 지연 안내",
        category = "[지누 티비 트레이]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "추가 배송 지연 안내",
        category = "[설백 6주년 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "추가 배송 지연 안내",
        category = "[설백 6주년 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "추가 배송 지연 안내",
        category = "[설백 6주년 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "추가 배송 지연 안내",
        category = "[설백 6주년 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "추가 배송 지연 안내",
        category = "[설백 6주년 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
)

val QuestionList = listOf(
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 전]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 전]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
)