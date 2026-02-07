package org.example.project.utill

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Serializable
data class Address(
    val id: String,
    val addressName: String,
    val addressRoad: String,
    val addressDetail: String,
    val addressZipCode: String,
)

data class AddressUI(
    val id: String,
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
@Immutable
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

data class CartUI(
    val name: String,
    val price: Int,
    val quantity: Int,
    val description: String,
    val isChecked: Boolean = true
)

@Serializable
data class Post(
    val title: String,
    val author: String,
    val category: String?,
    val content: String,
    val createdAt: String,
    val tag: String?,
)

data class PostUI(
    val title: String,
    val author: String,
    val tag: String?,
    val category: String?,
    val content: String,
    val createdAt: String,
)

@Serializable
data class FAQ(
    val id: String,
    val question: String,
    val answer: String,
)