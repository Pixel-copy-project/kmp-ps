package com.example.project

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuOpen
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.example.project.components.MenuDrawer
import org.example.project.screens.*
import org.example.project.utill.AppNav
import org.example.project.utill.handleNavigation

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
                    onClick = { navController.navigate(AppNav.Notice) },
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
            composable<AppNav.Buy> {
                BuyScreen(
                    onNavigate = navController::handleNavigation
                )
            }
            composable<AppNav.AddressSelect> {
                AddressSelectScreen(
                    onNavigate = navController::handleNavigation
                )
            }
            composable<AppNav.AddressAppend>{
                AddressAppendScreen()
            }
            composable<AppNav.Notice>{
                NoticeScreen(onNavigate = navController::handleNavigation)
            }
            composable<AppNav.QA>{
                QAScreen(onNavigate = navController::handleNavigation)
            }
            composable<AppNav.FAQ>{
                FAQScreen()
            }
            composable<AppNav.Post>{ backStackEntry ->
                val post = backStackEntry.toRoute<AppNav.Post>()
                PostScreen(
                    title = post.title,
                    writer = post.writer,
                    category = post.category,
                    content = post.content,
                    createdAt = post.createdAt,
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