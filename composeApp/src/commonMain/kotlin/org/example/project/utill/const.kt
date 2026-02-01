package org.example.project.utill

import kotlinx.serialization.Serializable

enum class QaTag(val answer: String) {
    BEFORE("[답변 전]"),
    COMPLETE("[답변 완료]"),
}

data class Address(
    val addressName: String,
    val addressRoad: String,
    val addressDetail: String,
    val addressZipCode: String,
)

data class DisplayAddress(
    val addressName: String,
    val addressRoad: String,
    val addressDetail: String,
    val addressZipCode: String,
)

@Serializable
data class Product(
    val id: String,
    val name: String,
    val price: Int,
    val quantity: Int,
    val description: String,
    val imgName: String,
)

data class ProductUI(
    val id: String,
    val name: String,
    val price: Int,
    val quantity: Int,
    val description: String,
    val imageName: String,
)

@Serializable
data class Cart(
    val id: String,
    val name: String,
    val price: Int,
    val description: String,
    val quantity: Int,
)

data class DisplayCartItem(
    val name: String,
    val price: Int,
    val quantity: Int,
    val description: String,
    val isChecked: Boolean = true
)

data class Notice(
    val title: String,
    val writer: String,
    val category: String,
    val tag: String,
    val content: String,
    val createdAt: String,
)

data class DisplayNotice(
    val title: String,
    val writer: String,
    val category: String,
    val tag: String,
    val content: String,
    val createdAt: String,
)

data class Question(
    val title: String,
    val writer: String,
    val category: String,
    val content: String,
    val createdAt: String,
    val tag: QaTag = QaTag.BEFORE,
    val goodsName: String,
)

data class DisplayQuestion(
    val title: String,
    val writer: String,
    val category: String,
    val content: String,
    val createdAt: String,
    val tag: QaTag = QaTag.BEFORE,
    val goodsName: String,
)

val NoticeList = listOf(
    Notice(
        title = "아구이뽀 맥주컵 굿즈",
        category = "Notice",
        tag = "[신규 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "배송 지연 안내",
        category = "Notice",
        tag = "[신규 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = " 나나양 점착메모지/스티커/아크릴 스탠드",
        category = "Notice",
        tag = "[신규 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "추가 배송 지연 안내",
        category = "Notice",
        tag = "[신규 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "아구이뽀 맥주컵 굿즈",
        category = "Notice",
        tag = "[신규 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "배송 지연 안내",
        category = "Notice",
        tag = "[신규 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "추가 배송 지연 안내",
        category = "Notice",
        tag = "[신규 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "아구이뽀 맥주컵 굿즈",
        category = "Notice",
        tag = "[지누 티비 트레이]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "배송 지연 안내",
        category = "Notice",
        tag = "[지누 티비 트레이]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "배송 지연 안내",
        category = "Notice",
        tag = "[지누 티비 트레이]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "추가 배송 지연 안내",
        category = "Notice",
        tag = "[신규 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "추가 배송 지연 안내",
        category = "Notice",
        tag = "[설백 6주년 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "추가 배송 지연 안내",
        category = "Notice",
        tag = "[설백 6주년 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "추가 배송 지연 안내",
        category = "Notice",
        tag = "[설백 6주년 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
    Notice(
        title = "추가 배송 지연 안내",
        category = "Notice",
        tag = "[설백 6주년 굿즈]",
        writer = "관리자",
        content = "공지사항",
        createdAt = "2025-11-18"
    ),
)

val QuestionList = listOf(
    Question(
        title = "추가 배송 지연 안내 1",
        category = "[답변 전]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-11",
        goodsName = "지누 티비 트레이"
    ),
    Question(
        title = "추가 배송 지연 안내 2",
        category = "[답변 전]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-12",
        goodsName = "지누 티비 트레이"
    ),
    Question(
        title = "추가 배송 지연 안내 3",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-13",
        tag = QaTag.COMPLETE,
        goodsName = "지누 티비 트레이"

    ),
    Question(
        title = "추가 배송 지연 안내 4",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-14",
        tag = QaTag.COMPLETE,
        goodsName = "지누 티비 트레이"

    ),
    Question(
        title = "추가 배송 지연 안내 5",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        tag = QaTag.COMPLETE,
        createdAt = "2025-11-15",
        goodsName = "지누 티비 트레이"

    ),
    Question(
        title = "추가 배송 지연 안내 6",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-16",
        goodsName = "지누 티비 트레이"

    ),
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        tag = QaTag.COMPLETE,
        createdAt = "2025-11-18",
        goodsName = "지누 티비 트레이"

    ),
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        tag = QaTag.COMPLETE,
        createdAt = "2025-11-18",
        goodsName = "지누 티비 트레이"

    ),
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        createdAt = "2025-11-18",
        goodsName = "지누 티비 트레이"


    ),
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        tag = QaTag.COMPLETE,
        createdAt = "2025-11-18",
        goodsName = "지누 티비 트레이"

    ),
    Question(
        title = "추가 배송 지연 안내",
        category = "[답변 완료]",
        writer = "시청자1",
        content = "공지사항",
        tag = QaTag.COMPLETE,
        createdAt = "2025-11-18",
        goodsName = "지누 티비 트레이"

    ),
)