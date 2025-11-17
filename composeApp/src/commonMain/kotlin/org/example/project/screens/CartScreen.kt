package org.example.project.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.components.CartItemComponent
import org.example.project.ui.theme.AppBackground
import org.example.project.utill.NavigationEvent

@Composable
fun CartScreen(
    onNavigate: (NavigationEvent) -> Unit,
){
    val scrollState = rememberScrollState()
    Box() {
        Column(
            modifier = Modifier
                .background(AppBackground)
                .verticalScroll(scrollState)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(18.dp))
                Checkbox(
                    checked = false,
                    modifier = Modifier
                        .size(48.dp),
                    onCheckedChange = {}
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "전체선택",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                repeat(3) {
                    CartItemComponent(
                        rootModifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White),
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 18.dp, top = 16.dp, end = 18.dp)
                ) {
                    Text(
                        text = "총 결제금액",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        repeat(3) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    text = "상품명",
                                    fontSize = 18.sp,
                                    color = Color(0xFF333333),
                                )
                                Text(
                                    text = "18,500원",
                                    fontSize = 20.sp,
                                    color = Color(0xFF999999),
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalDivider(color = Color.Black)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "55,500원",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.End),
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            TextButton(
                onClick = { onNavigate(NavigationEvent.NavigateToBuy) },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "55,000원 구매하기",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
        if((scrollState.value / scrollState.maxValue) < 0.8f ){
            TextButton(
                onClick = { onNavigate(NavigationEvent.NavigateToBuy) },
                shape = RoundedCornerShape(
                    topStart = 8.dp, topEnd = 8.dp,
                    bottomStart = 0.dp, bottomEnd = 0.dp
                ),
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    text = "55,000원 구매하기",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}