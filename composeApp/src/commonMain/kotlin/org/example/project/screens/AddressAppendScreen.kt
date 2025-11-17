package org.example.project.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddressAppendScreen() {
    val detailAddressList = listOf(
        Pair("경기도 성남시 대왕판교로", "18340"),
        Pair("경기도 평택시 중앙로", "18240"),
        Pair("경기도 평택시 비전로", "16430"),
        Pair("경기도 평택시 고덕로", "17560"),
    )
    var showOverlay by remember { mutableStateOf(true) }

    Column(
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            OutlinedTextField(
                state = rememberTextFieldState(),
                placeholder = {
                    Text(
                        text = "경기도 성남시 대왕판교로 머시기 205-1023호",
                        fontSize = 16.sp,
                        color = Color(0xFF666666),
                        maxLines = 1,
                    )
                },
                //colors = TextFieldDefaults.colors(Color.White),
                modifier = Modifier
                    .width(300.dp)
            )
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(0.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color(0xFF666666)
                ),
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 16.dp),
            ) {
                Text(
                    text = "검색",
                    fontSize = 16.sp,
                    color = Color(0xFF666666),
                )
            }
        }
        Box(
            modifier = Modifier.padding(start = 12.dp)
        ) {
            Text(
                text = "상세주소 입력",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
            )
        }
        Spacer(modifier = Modifier.height(22.dp))
        Column(
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            detailAddressList.forEach { it ->
                Spacer(modifier = Modifier.height(22.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(46.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column() {
                        Text(
                            text = "도로명 주소",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF666666),
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "우편번호",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF666666),
                        )
                    }
                    Column() {
                        Text(
                            text = it.first,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF000000),
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = it.second,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF000000),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(22.dp))
                HorizontalDivider(modifier = Modifier.fillMaxWidth())
            }
        }
    }
    if (showOverlay) {
        Box(
            modifier = Modifier
                .background(Color(0xAA000000))
                .padding(horizontal = 24.dp)
        ) {
            Box(
                modifier = Modifier
                    .offset(y = 104.dp)
                    .background(Color.White)
            ) {
                IconButton(
                    onClick = { showOverlay = false },
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.TopEnd)
                        .offset(x = (-20).dp ,y = 20.dp)
                ){
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(horizontal = 36.dp, vertical = 14.dp)
                ) {
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "경기도 평택시 중앙 30로 952가 A동 1004호",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        maxLines = 2,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    TextField(
                        state = rememberTextFieldState(),
                        placeholder = {
                            Text(
                                text = "상세 주소 입력",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Light,
                                color = Color(0xFF666666),
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                        ),
                        keyboardOptions = KeyboardOptions.Default,
                    )
                    Spacer(modifier = Modifier.height(70.dp))
                    OutlinedButton(
                        onClick = {
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White),
                        shape = RoundedCornerShape(0.dp),
                        border = BorderStroke(
                            width = 2.dp,
                            color = Color(0xFF999999)
                        )
                    ) {
                        Text(
                            text = "배송지 추가하기",
                            fontSize = 18.sp,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(vertical = 4.dp)
                        )
                    }
                }
            }
        }
    }
}