package org.example.project.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.example.project.utill.Product
import org.example.project.utill.Post
import org.example.project.utill.Address
import org.example.project.viewmodel.Faq

class PixelRepository(private val client: HttpClient):
    GoodsRepository, PostRepository, CartRepository, AddressRepository, FaqRepository
{
    private val goodsList = listOf<Product>(
        Product(
            id = "1",
            name = "상품 1",
            description = "[예약구매] 11월 9일 일요일 오후 11시까지",
            price = 17000,
            quantity = 100,
            imgName = ""
        ),
        Product(
            id = "2",
            name = "상품 2",
            description = "[예약구매] 11월 9일 일요일 오후 11시까지",
            price = 40000,
            quantity = 100,
            imgName = ""
        ),
        Product(
            id = "3",
            name = "상품 3",
            description = "[예약구매] 11월 9일 일요일 오후 11시까지",
            price = 14000,
            quantity = 100,
            imgName = ""
        ),
        Product(
            id = "4",
            name = "상품 2",
            description = "[예약구매] 11월 9일 일요일 오후 11시까지",
            price = 18500,
            quantity = 0,
            imgName = ""
        ),
        Product(
            id = "5",
            name = "상품 2",
            description = "[예약구매] 11월 9일 일요일 오후 11시까지",
            price = 18500,
            quantity = 100,
            imgName = ""
        ),
        Product(
            id = "6",
            name = "상품 2",
            description = "[예약구매] 11월 9일 일요일 오후 11시까지",
            price = 18500,
            quantity = 0,
            imgName = ""
        ),
        Product(
            id = "7",
            name = "상품 2",
            description = "[예약구매] 11월 9일 일요일 오후 11시까지",
            price = 18500,
            quantity = 100,
            imgName = ""
        ),
    )

    val postLists = listOf(
        Post(
            title = "추가 배송 지연 안내 1",
            category = "[답변 전]",
            author = "시청자1",
            content = "공지사항",
            createdAt = "2025-11-11",
            tag = "지누 티비 트레이"
        ),
        Post(
            title = "추가 배송 지연 안내 2",
            category = "[답변 전]",
            author = "시청자1",
            content = "공지사항",
            createdAt = "2025-11-12",
            tag = "지누 티비 트레이"
        ),
        Post(
            title = "추가 배송 지연 안내 3",
            category = "[답변 완료]",
            author = "시청자1",
            content = "공지사항",
            createdAt = "2025-11-13",
            tag = "지누 티비 트레이"

        ),
        Post(
            title = "추가 배송 지연 안내 4",
            category = "[답변 완료]",
            author = "시청자1",
            content = "공지사항",
            createdAt = "2025-11-14",
            tag = "지누 티비 트레이"

        ),
        Post(
            title = "추가 배송 지연 안내 5",
            category = "[답변 완료]",
            author = "시청자1",
            content = "공지사항",
            createdAt = "2025-11-15",
            tag = "지누 티비 트레이"

        ),
        Post(
            title = "추가 배송 지연 안내 6",
            category = "[답변 완료]",
            author = "시청자1",
            content = "공지사항",
            createdAt = "2025-11-16",
            tag = "지누 티비 트레이"

        ),
        Post(
            title = "추가 배송 지연 안내",
            category = "[답변 완료]",
            author = "시청자1",
            content = "공지사항",
            createdAt = "2025-11-18",
            tag = "지누 티비 트레이"

        ),
        Post(
            title = "추가 배송 지연 안내",
            category = "[답변 완료]",
            author = "시청자1",
            content = "공지사항",
            createdAt = "2025-11-18",
            tag = "지누 티비 트레이"

        ),
        Post(
            title = "추가 배송 지연 안내",
            category = "[답변 완료]",
            author = "시청자1",
            content = "공지사항",
            createdAt = "2025-11-18",
            tag = "지누 티비 트레이"
        ),
        Post(
            title = "추가 배송 지연 안내",
            category = "[답변 완료]",
            author = "시청자1",
            content = "공지사항",
            createdAt = "2025-11-18",
            tag = "지누 티비 트레이"

        ),
        Post(
            title = "추가 배송 지연 안내",
            category = "[답변 완료]",
            author = "시청자1",
            content = "공지사항",
            createdAt = "2025-11-18",
            tag = "지누 티비 트레이"

        ),
    )

    var cart: List<Product> = listOf(
        goodsList[0], goodsList[1]
    )

    var addressList: List<Address> = listOf(
        Address(
            addressName = "우리집",
            addressDetail = "1004동 2005호",
            addressRoad = "경기 경기 중앙로 중앙로 20 30",
            addressZipCode = "37748"
        ),
        Address(
            addressName ="사무실",
            addressDetail = "1004동 2005호",
            addressRoad = "경기 경기 중앙로 중앙로 40 30",
            addressZipCode = "37748"
        ),
        Address(
            addressName ="자취방",
            addressDetail = "1004동 2005호",
            addressRoad = "경기 경기 중앙로 중앙로 60 30",
            addressZipCode = "37748"
        ),
    )

    override suspend fun getProducts(): List<Product>{
        return client.get("http://10.0.2.2:8080/products").body()
    }

    override suspend fun getProductByName(name: String): Product? {
        return client.get("http://10.0.2.2:8080/products/byName/$name").body()
    }

    override suspend fun getPost(): List<Post> {
        return client.get("http://10.0.2.2:8080/post").body()
    }

    override suspend fun getPostByTitle(title: String): Post? {
        return client.get("http://10.0.2.2:8080/post/byTitle/$title").body()
    }

    override suspend fun getCart(): List<Product> {
        return cart
    }

    override suspend fun getAddressList(): List<Address> {
        return addressList
    }

    override suspend fun getAllFaq(): List<Faq> {
        return client.get("http://10.0.2.2:8080/faq").body()
    }
}