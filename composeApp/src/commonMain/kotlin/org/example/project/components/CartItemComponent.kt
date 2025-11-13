package org.example.project.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.goods_1
import org.jetbrains.compose.resources.painterResource

@Composable
fun CartItemComponent(rootModifier: Modifier = Modifier) {
    Box(
        modifier = rootModifier
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Row() {
                Spacer(modifier = Modifier.width(6.dp))
                Checkbox(
                    checked = false,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(48.dp),
                    onCheckedChange = {},
                )
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
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(modifier = Modifier.width(51.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ){
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Text(
                        text = "1",
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                    )
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
                Spacer(modifier = Modifier.width(100.dp))
                Text(
                    text = "17,000원",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
        IconButton(
            modifier = Modifier
                .size(30.dp)
                .align(Alignment.TopEnd)
                .padding(top = 12.dp, end = 12.dp),
            onClick = {},
        ){
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}