package org.example.project.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.katalk
import kmpproject.composeapp.generated.resources.main_banner_1
import org.example.project.components.GoodsComponent
import org.example.project.ui.theme.AppBackground
import org.example.project.ui.theme.NoticeCategory
import org.example.project.ui.theme.SectionBackground
import org.example.project.utill.NavigationEvent
import org.example.project.utill.goodsList
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainScreen(onNavigate: (NavigationEvent) -> Unit) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(AppBackground)
            .verticalScroll(state = scrollState)
    ) {
        /* Banner */
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp)
                .height(194.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.main_banner_1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        /* Notice */
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 12.dp, end = 12.dp)
                .height(138.dp)
                .background(SectionBackground)
        ) {
            Row(){
                Box(
                    modifier = Modifier
                        .weight(0.4f)
                ){
                    Text(
                        text = "공지사항\nNotice",
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        fontWeight = Bold,
                        lineHeight = 24.sp,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .offset(y = 36.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(0.6f)
                ){
                    Column (
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .align(Alignment.Center)
                    ){
                        Row(){
                            Text(
                                text = "[신규굿즈]",
                                color = NoticeCategory,
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "아구이뽀 맥주컵 굿즈",
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                            )
                        }
                        Row(){
                            Text(
                                text = "[신규굿즈]",
                                color = NoticeCategory,
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "아구이뽀 맥주컵 굿즈",
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                            )
                        }
                        Row(){
                            Text(
                                text = "[신규굿즈]",
                                color = NoticeCategory,
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "아구이뽀 맥주컵 굿즈",
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                            )
                        }
                        Row(){
                            Text(
                                text = "[신규굿즈]",
                                color = NoticeCategory,
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "아구이뽀 맥주컵 굿즈",
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                            )
                        }
                    }
                }
            }
            Text(
                text = "더보기 >>",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 8.dp, end = 16.dp)
            )
        }

        /* New Goods */
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 12.dp, end = 12.dp)
                .background(SectionBackground)
        ) {
            Text(
                text = "새로 나왔어요!",
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
            Spacer(modifier = Modifier.height(21.dp))
            FlowRow()
            {
                repeat(3) {
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White,
                            disabledContainerColor = Color.Black,
                            disabledContentColor = Color.White
                        ),
                        modifier = Modifier
                            .padding(start = 4.dp, end = 4.dp)
                    ){
                        Text(
                            text = "카테고리"
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(18.dp))
            FlowRow(
                maxItemsInEachRow = 2,
                maxLines = 2,
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ){
                goodsList.take(4).forEach { it ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.48f)
                            .height(324.dp)
                    ) {
                        GoodsComponent(
                            modifier = Modifier
                                .fillMaxSize(),
                            goodsImg = it.imageRes,
                            goodsName = it.name,
                            goodsDescription = it.description,
                            goodsPrice = it.price,
                            quantity = it.quantity,
                            onNavigate = onNavigate
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(48.dp))
            OutlinedButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(start = 14.dp, end = 14.dp)
                ,
                onClick = {

                },
                shape = RoundedCornerShape(
                    8.dp
                ),
                border = BorderStroke(
                    width = 2.dp,
                    color = Color(0xFF999999)
                )
            ){
                Row {
                    Text(
                        text = "더 많은 상품 보러가기",
                        color = Color(0xFF666666),
                        lineHeight = 24.sp,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(top = 6.dp, bottom = 6.dp)
                    )
                    Icon(
                        imageVector =  Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(30.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
        Spacer(modifier = Modifier.height(54.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(233.dp)
                .padding(start = 12.dp, end = 12.dp)
        ){
            Image(
                painter = painterResource(Res.drawable.katalk),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable{

                    }
            )
        }
        Spacer(modifier = Modifier.height(56.dp))
    }

}