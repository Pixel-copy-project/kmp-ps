package com.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
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
import androidx.navigation.NavController
import kotlinx.serialization.Serializable

import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.compose_multiplatform
import org.example.project.GoodsDetailScreen
import org.example.project.GoodsListScreen
import org.example.project.MainScreen
import org.jetbrains.compose.resources.painterResource

sealed class AppNav {
    @Serializable
    object Main

    @Serializable
    object GoodsList

    @Serializable
    object GoodsDetail
}

sealed interface NavigationEvent {
    data object NavigateToMain : NavigationEvent
    data object NavigateToGoodsList : NavigationEvent
    data object NavigateToGoodsDetail : NavigationEvent
}

fun NavHostController.handleNavigation(event: NavigationEvent) {
    when (event) {
        NavigationEvent.NavigateToMain -> navigate(AppNav.Main)
        NavigationEvent.NavigateToGoodsList -> navigate(AppNav.GoodsList)
        NavigationEvent.NavigateToGoodsDetail -> navigate(AppNav.GoodsDetail)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    onNavHostReady: suspend (NavController) -> Unit = {}
) {
    val navController = rememberNavController()
    var showDrawer by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(
                    text = "Pixel store",
                    textAlign = TextAlign.Center,
                ) },
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
                    onClick = {  },
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
                    onClick = {  },
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
                    onClick = {  },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                )
            }
        }
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
            composable<AppNav.GoodsDetail> {
                GoodsDetailScreen(
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
                SampleDrawer(
                    paddingValues = paddingValues,
                    onNavigate = navController::handleNavigation,
                )
            }
        }
    }
}

@Composable
fun SampleDrawer(
    paddingValues: PaddingValues,
    onNavigate: (NavigationEvent) -> Unit,
) {
    var isShow by remember { mutableStateOf(false) }
    val animAlpha : Float by animateFloatAsState(
        targetValue = if(isShow) 1f else 0f,
        animationSpec = keyframes {
            delayMillis = 700
            0f at 0 using EaseIn
            1f at 1000 using EaseOut
        }
    )
    LaunchedEffect(Unit) {
        isShow = true
    }
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .width(200.dp)
            .fillMaxHeight()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .alpha(animAlpha)
    ) {
        NavigationDrawerItem(
            label = { Text("Item 1") },
            selected = false,
            onClick = { onNavigate(NavigationEvent.NavigateToMain) }
        )
        NavigationDrawerItem(
            label = { Text("Item 2") },
            selected = false,
            onClick = { onNavigate(NavigationEvent.NavigateToGoodsList) }
        )
        NavigationDrawerItem(
            label = { Text("Settings") },
            selected = false,
            badge = { Text("20") },
            onClick = { onNavigate(NavigationEvent.NavigateToGoodsDetail) }
        )
        NavigationDrawerItem(
            label = { Text("Help and feedback") },
            selected = false,
            onClick = { /* Handle click */ },
        )
        Spacer(Modifier.height(12.dp))
    }
}