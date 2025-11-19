package org.example.project.components

import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.ui.theme.MenuBackground
import org.example.project.utill.NavigationEvent

@Composable
fun MenuDrawer(
    paddingValues: PaddingValues,
    onNavigate: (NavigationEvent) -> Unit,
    onCloseDrawer: () -> Unit
) {
    val scope = rememberCoroutineScope()
    var isShow by remember { mutableStateOf(false) }
    val animAlpha: Float by animateFloatAsState(
        targetValue = if (isShow) 1f else 0f,
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
            .fillMaxSize()
            .background(MenuBackground)
            .verticalScroll(rememberScrollState())
            .alpha(animAlpha)
    ) {
        NavigationDrawerItem(
            label = { Text(text = "공지사항", fontSize = 24.sp) },
            selected = false,
            badge = {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.Gray,
                )
            },
            onClick = {
                onCloseDrawer()
                onNavigate(NavigationEvent.NavigateToNotice) }
        )
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

        NavigationDrawerItem(
            label = { Text("자주하는 질문", fontSize = 24.sp) },
            selected = false,
            badge = {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.Gray,
                )
            },
            onClick = {
                onCloseDrawer()
                onNavigate(NavigationEvent.NavigateToFAQ) }
        )
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        NavigationDrawerItem(
            label = { Text("질문 & 답변", fontSize = 24.sp) },
            selected = false,
            badge = {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.Gray,
                )
            },
            onClick = {
                onCloseDrawer()
                onNavigate(NavigationEvent.NavigateToQA) }
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        NavigationDrawerItem(
            label = { Text("상품", fontSize = 24.sp) },
            selected = false,
            badge = {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.Gray,
                )
            },
            onClick =  {
                onCloseDrawer()
                onNavigate(NavigationEvent.NavigateToGoodsList) }

        )
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        NavigationDrawerItem(
            label = { Text("장바구니, 주문", fontSize = 24.sp) },
            selected = false,
            badge = {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.Gray,
                )
            },
            onClick = {
                onCloseDrawer()
                onNavigate(NavigationEvent.NavigateToCart) },
        )
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        NavigationDrawerItem(
            label = { Text("리뷰", fontSize = 24.sp) },
            selected = false,
            badge = {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.Gray,
                )
            },
            onClick = {
                onCloseDrawer()
                onNavigate(NavigationEvent.NavigateToReview) },
        )
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        NavigationDrawerItem(
            label = { Text("마이페이지", fontSize = 24.sp) },
            selected = false,
            badge = {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.Gray,
                )
            },
            onClick = { /* Handle click */ },
        )
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        NavigationDrawerItem(
            label = { Text("카카오톡 문의", fontSize = 24.sp) },
            selected = false,
            badge = {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.Gray,
                )
            },
            onClick = { /* Handle click */ },
        )
    }
}