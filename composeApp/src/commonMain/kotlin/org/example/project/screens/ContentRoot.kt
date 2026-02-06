package org.example.project.screens

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Assignment
import androidx.compose.material.icons.automirrored.outlined.MenuOpen
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.example.project.components.MenuDrawer
import org.example.project.utill.AppNav
import org.example.project.utill.handleNavigation
import org.example.project.viewmodel.AddressViewModel
import org.example.project.viewmodel.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentRoot(){
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
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
                        onClick = {
                            if(showDrawer){
                                showDrawer = false
                            }else{
                                navController.popBackStack()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "BackStackPop"
                        )
                    }
                },
                actions = {
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
                    onClick = {
                        navController.navigate(AppNav.Notice)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Assignment,
                            contentDescription = "Home",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate(AppNav.Main)
                    },
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
                    onClick = {
                        navController.navigate(AppNav.Cart)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "Home",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate(AppNav.MyPage)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
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

        val addressViewModel = AddressViewModel()
        val cartViewModel = CartViewModel()

        NavHost(
            navController = navController,
            startDestination = AppNav.Main,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            composable<AppNav.SignIn>{
                SignInScreen(
                    onNavigate = navController::handleNavigation,
                )
            }
            composable<AppNav.BaseSignUp>{
                BaseSignUpScreen(
                    onNavigate = navController::handleNavigation,
                )
            }
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
                    imageName = goodsDetail.imageName,
                )
            }
            composable<AppNav.Cart> {
                CartScreen(
                    onNavigate = navController::handleNavigation,
                    cartViewModel = cartViewModel
                )
            }
            composable<AppNav.Buy> {
                BuyScreen(
                    onNavigate = navController::handleNavigation,
                    addressViewModel = addressViewModel,
                )
            }
            composable<AppNav.AddressSelect> {
                AddressSelectScreen(
                    onNavigate = navController::handleNavigation,
                    addressViewModel = addressViewModel,
                )
            }
            composable<AppNav.AddressAppend>{
                AddressAppendScreen(
                    onNavigate = navController::handleNavigation,
                    addressViewModel = addressViewModel,
                )
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
                PostDetailScreen(
                    title = post.title,
                    author = post.author,
                    tag = post.tag,
                    category = post.category,
                    content = post.content,
                    createdAt = post.createdAt,
                    onNavigate = navController::handleNavigation,
                )
            }
            composable<AppNav.Review> {
                ReviewScreen(onNavigate = navController::handleNavigation)
            }
            composable<AppNav.PostEdit>{ backStackEntry ->
                val category = backStackEntry.toRoute<AppNav.PostEdit>()
                PostEditScreen(
                    category = category.postCategory,
                    onNavigate = navController::handleNavigation
                )
            }
            composable<AppNav.ReviewEdit>{ backStackEntry ->
                val reviewItem = backStackEntry.toRoute<AppNav.ReviewEdit>()
                ReviewEditScreen(
                    onNavigate = navController::handleNavigation,
                    reviewItem = reviewItem.reviewItem
                )
            }
            composable<AppNav.MyPage>{
                MyPageScreen(
                    onNavigate = navController::handleNavigation,
                )
            }
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