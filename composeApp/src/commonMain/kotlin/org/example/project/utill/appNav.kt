package org.example.project.utill

import androidx.navigation.NavHostController
import kotlinx.serialization.Serializable

sealed class AppNav {
    @Serializable
    object Main

    @Serializable
    object GoodsList

    @Serializable
    data class GoodsDetail(
        val goodsName: String,
        val goodsDescription: String,
        val goodsPrice: Int,
        val quantity: Int,
    )

    @Serializable
    object Cart

    @Serializable
    object Buy

    @Serializable
    object AddressSelect

    @Serializable
    object AddressAppend

    @Serializable
    object Notice

    @Serializable
    object QA

    @Serializable
    object FAQ

    @Serializable
    data class Post(
        val title: String,
        val writer: String,
        val category: String,
        val content: String,
        val createdAt: String,
    )

    @Serializable
    object Review

    @Serializable
    data class PostEdit(
        val postCategory: String,
    )

    @Serializable
    data class ReviewEdit(
        val reviewItem: String? = null,
    )
}

sealed interface NavigationEvent {
    data object NavigateToMain : NavigationEvent
    data object NavigateToGoodsList : NavigationEvent
    data class NavigateToGoodsDetail(
        val goodsName: String,
        val goodsDescription: String,
        val goodsPrice: Int,
        val quantity: Int,
    ) : NavigationEvent

    data object NavigateToCart : NavigationEvent
    data object NavigateToBuy : NavigationEvent
    data object NavigateToAddressSelect : NavigationEvent
    data object NavigateToAddressAppend : NavigationEvent
    data object NavigateToNotice : NavigationEvent
    data object NavigateToQA : NavigationEvent
    data object NavigateToFAQ : NavigationEvent
    data class NavigateToPost(
        val title: String,
        val writer: String,
        val category: String,
        val content: String,
        val createdAt: String,
    ) : NavigationEvent

    data object NavigateToReview : NavigationEvent
    data class NavigateToPostEdit(
        val postCategory: String,
    ) : NavigationEvent
    data class NavigateToReviewEdit(
        val reviewItem: String? = null,
    ): NavigationEvent
    data object NavigationBack : NavigationEvent
}

fun NavHostController.handleNavigation(event: NavigationEvent) {
    when (event) {
        NavigationEvent.NavigateToMain -> navigate(AppNav.Main)
        NavigationEvent.NavigateToGoodsList -> navigate(AppNav.GoodsList)
        is NavigationEvent.NavigateToGoodsDetail -> navigate(
            AppNav.GoodsDetail(
                event.goodsName,
                event.goodsDescription,
                event.goodsPrice,
                event.quantity,
            )
        )
        NavigationEvent.NavigateToCart -> navigate(AppNav.Cart)
        NavigationEvent.NavigateToBuy -> navigate(AppNav.Buy)
        NavigationEvent.NavigateToAddressSelect -> navigate(AppNav.AddressSelect)
        NavigationEvent.NavigateToAddressAppend -> navigate(AppNav.AddressAppend)
        NavigationEvent.NavigateToNotice -> navigate(AppNav.Notice)
        NavigationEvent.NavigateToQA -> navigate(AppNav.QA)
        NavigationEvent.NavigateToFAQ -> navigate(AppNav.FAQ)
        is NavigationEvent.NavigateToPost -> navigate(
            AppNav.Post(
                event.title,
                event.writer,
                event.category,
                event.content,
                event.createdAt,
            )
        )
        NavigationEvent.NavigateToReview -> navigate(AppNav.Review)
        is NavigationEvent.NavigateToPostEdit -> navigate(
                AppNav.PostEdit(
                    event.postCategory,
                )
            )
        is NavigationEvent.NavigateToReviewEdit -> navigate(
            AppNav.ReviewEdit(
                event.reviewItem,
            )
        )
        NavigationEvent.NavigationBack -> popBackStack()
    }
}