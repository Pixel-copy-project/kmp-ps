package org.example.project.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.components.BuyItemComponent
import org.example.project.components.GoodsReviewComponent
import org.example.project.components.PostTitleComponent
import org.example.project.ui.theme.AppBackground0
import org.example.project.utill.NavigationEvent
import org.example.project.utill.QuestionList
import org.example.project.utill.goodsList

@Composable
fun MyPageScreen(onNavigate: (NavigationEvent) -> Unit) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(AppBackground0)
            .padding(horizontal = 12.dp)
    ){
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.White)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(460.dp)
                .background(Color.White)
        ){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
            ){
                Text(
                    text = "최근 구매이력",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)){
                    Text(
                        text = "전체보기",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF999999)
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                    )
                }
            }
            goodsList.take(3).forEach {
                BuyItemComponent(
                    goodsName = it.name,
                    goodsPrice = it.price,
                    description = it.description,
                    rootModifier = Modifier.padding(top = 12.dp),
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ){
            Column (
                verticalArrangement = Arrangement.spacedBy(14.dp),
            ){
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
                        .clickable(
                            onClick = {onNavigate(NavigationEvent.NavigateToQA)}
                        )
                ) {
                    Text(
                        text = "내 문의사항",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = "문의사항 바로가기",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF999999)
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = null,
                        )
                    }
                }
                QuestionList.take(3).forEach {
                    PostTitleComponent(
                        tag = it.tag.answer,
                        title = it.title,
                        category = it.category,
                        onNavigate = onNavigate,
                        fontSize = 18,
                        goodsName = it.goodsName,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ){
            Column (
                verticalArrangement = Arrangement.spacedBy(14.dp),
            ){
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
                ) {
                    Text(
                        text = "내 리뷰",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.clickable(
                            onClick = {onNavigate(NavigationEvent.NavigateToReview)}
                        )
                    ) {
                        Text(
                            text = "다른 리뷰 보러가기",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF999999)
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = null,
                        )
                    }
                }
                repeat(3) {
                    GoodsReviewComponent("리뷰 내용 나오는...리뷰 내용 나오는...리뷰 내용 나오는...리뷰 내용 나오는...리뷰 내용 나오는...리뷰 내용 나오는...리뷰 내용 나오는...")
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}