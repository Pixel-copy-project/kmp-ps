package org.example.project.utill

import androidx.navigation.NavHostController
import kotlinx.serialization.Serializable

sealed class AppNav {
    @Serializable
    object SignIn
    @Serializable
    object BaseSignUp
    @Serializable
    object KakaoSignUp
    @Serializable
    object GoogleSignUp
    @Serializable
    object XSignUp
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
        val tag: String,
        val postCategory: String,
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

    @Serializable
    object MyPage
}

sealed interface NavigationEvent {
    data object SignIn : NavigationEvent
    data object BaseSignUp : NavigationEvent
    data object KakaoSignUp : NavigationEvent
    data object GoogleSignUp : NavigationEvent
    data object XSignUp : NavigationEvent
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
        val tag: String,
        val postCategory: String,
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
    data object NavigateToMyPage : NavigationEvent
    data object NavigationBack : NavigationEvent
}

fun NavHostController.handleNavigation(event: NavigationEvent) {
    when (event) {
        NavigationEvent.SignIn -> navigate(AppNav.SignIn)
        NavigationEvent.BaseSignUp -> navigate(AppNav.BaseSignUp)
        NavigationEvent.KakaoSignUp -> navigate(AppNav.KakaoSignUp)
        NavigationEvent.GoogleSignUp -> navigate(AppNav.GoogleSignUp)
        NavigationEvent.XSignUp -> navigate(AppNav.XSignUp)
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
                event.tag,
                event.postCategory,
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
        NavigationEvent.NavigateToMyPage -> navigate(AppNav.MyPage)
        NavigationEvent.NavigationBack -> popBackStack()
    }
}