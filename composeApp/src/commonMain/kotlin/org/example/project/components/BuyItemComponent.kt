package org.example.project.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.goods_1
import org.example.project.ui.theme.Purple80
import org.jetbrains.compose.resources.painterResource

@Composable
fun BuyItemComponent(rootModifier: Modifier = Modifier) {
    Box(
        modifier = rootModifier
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Row() {
                Spacer(modifier = Modifier.width(6.dp))
                Image(
                    painter = painterResource(Res.drawable.goods_1),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .size(80.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, top = 12.dp),
                ) {
                    Text(
                        text = "상품 이름",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF666666),
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "[예약구매] 11월 9일 일요일 오후 11시까지",
                        fontSize = 14.sp,
                        modifier = Modifier.width(204.dp)
                    )
                }
            }
            Text(
                text = "18,500원",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 10.dp)
            )
        }
    }
}