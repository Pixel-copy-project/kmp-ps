package com.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuOpen
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.example.project.CartScreen

import org.example.project.GoodsDetailScreen
import org.example.project.GoodsListScreen
import org.example.project.MainScreen
import org.example.project.components.MenuDrawer

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
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    onNavHostReady: suspend (NavController) -> Unit = {}
) {
    val listState = rememberLazyListState()

    // 2. CoroutineScope 생성 및 기억하기 (비동기 스크롤을 위해)
    val scope = rememberCoroutineScope()

    // 3. 스크롤 상태에 따라 버튼을 보여줄지 말지 결정하는 상태 (성능 최적화를 위해 derivedStateOf 사용)
    // 첫 번째 보이는 아이템의 인덱스가 0보다 크면 (즉, 최상단이 아니면) 버튼을 보여준다.
    val showButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }

    val navController = rememberNavController()
    var showDrawer by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Pixel store",
                        textAlign = TextAlign.Center,
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { showDrawer = !showDrawer }
                    ) {
                        Icon(
                            imageVector = if (showDrawer) Icons.AutoMirrored.Outlined.MenuOpen else Icons.Filled.Menu,
                            contentDescription = "Menu"
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(AppNav.Main) },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(AppNav.Cart) },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                )
            }
        },
        /*floatingActionButton = {
            IconButton(
                onClick = {
                    scope.launch {
                        listState.animateScrollToItem(0)
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowUp,
                    contentDescription = "FAB",
                    modifier = Modifier.size(48.dp)
                )
            }
        }*/
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = AppNav.Main,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            composable<AppNav.Main> {
                MainScreen(
                    onNavigate = navController::handleNavigation,
                )
            }
            composable<AppNav.GoodsList> {
                GoodsListScreen(
                    onNavigate = navController::handleNavigation,
                )
            }
            composable<AppNav.GoodsDetail> { backStackEntry ->
                val goodsDetail = backStackEntry.toRoute<AppNav.GoodsDetail>()
                GoodsDetailScreen(
                    onNavigate = navController::handleNavigation,
                    goodsName = goodsDetail.goodsName,
                    goodsDescription = goodsDetail.goodsDescription,
                    goodsPrice = goodsDetail.goodsPrice,
                    quantity = goodsDetail.quantity,
                )
            }
            composable<AppNav.Cart> {
                CartScreen(
                    onNavigate = navController::handleNavigation
                )
            }
        }
        LaunchedEffect(navController) {
            onNavHostReady(navController)
        }
        Row {
            AnimatedVisibility(
                visible = showDrawer,
                enter = slideInHorizontally() + expandHorizontally() + fadeIn(initialAlpha = 0.3f),
                exit = slideOutHorizontally() + shrinkHorizontally() + fadeOut()
            ) {
                MenuDrawer(
                    paddingValues = paddingValues,
                    onNavigate = navController::handleNavigation,
                    onCloseDrawer = { showDrawer = false },
                )
            }
        }
    }
}