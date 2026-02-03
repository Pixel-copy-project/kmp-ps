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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.katalk
import kmpproject.composeapp.generated.resources.main_banner_1
import org.example.project.components.GoodsComponent
import org.example.project.components.PostTitleComponent
import org.example.project.ui.theme.AppBackground0
import org.example.project.ui.theme.SectionBackground
import org.example.project.utill.NavigationEvent
import org.example.project.viewmodel.GoodsViewModel
import org.example.project.viewmodel.PostViewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(
    onNavigate: (NavigationEvent) -> Unit,
    viewModel: GoodsViewModel = GoodsViewModel(),
    postViewModel: PostViewModel = viewModel()
) {
    val scrollState = rememberScrollState()
    val goodsUiState by viewModel.uiState.collectAsState()
    val postUiState by postViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .background(AppBackground0)
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
            Row() {
                Box(
                    modifier = Modifier
                        .weight(0.4f)
                ) {
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
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .align(Alignment.Center)
                    ) {
                        postUiState.postList.take(4).forEach {
                            PostTitleComponent(
                                tag = it.tag,
                                category = it.category,
                                title = it.title,
                                fontSize = 14,
                                author = it.author,
                                content = it.content,
                                onNavigate = onNavigate
                            )

                        }
                    }
                }
            }
            Text(
                text = "더보기 >>",
                modifier = Modifier
                    .clickable(
                        onClick = {
                            onNavigate(NavigationEvent.NavigateToNotice)
                        }
                    )
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
                    ) {
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
            ) {
                goodsUiState.goodsList.take(4).forEach {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.48f)
                            .height(324.dp)
                    ) {
                        GoodsComponent(
                            modifier = Modifier
                                .fillMaxSize(),
                            goodsName = it.name,
                            goodsDescription = it.description,
                            goodsPrice = it.price,
                            quantity = it.quantity,
                            onNavigate = onNavigate,
                            imageName = it.imageName,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(48.dp))
            OutlinedButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(start = 14.dp, end = 14.dp),
                onClick = {
                    onNavigate(NavigationEvent.NavigateToGoodsList)
                },
                shape = RoundedCornerShape(
                    8.dp
                ),
                border = BorderStroke(
                    width = 2.dp,
                    color = Color(0xFF999999)
                )
            ) {
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
                        imageVector = Icons.Default.KeyboardArrowRight,
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
        ) {
            Image(
                painter = painterResource(Res.drawable.katalk),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {

                    }
            )
        }
        Spacer(modifier = Modifier.height(56.dp))
    }
}

@Preview
@Composable
fun PreviewMainScreen() = MainScreen(onNavigate = {})