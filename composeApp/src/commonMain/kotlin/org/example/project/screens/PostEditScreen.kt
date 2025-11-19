package org.example.project.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.utill.NavigationEvent

@Composable
fun PostEditScreen(
    postCategory: String = "Notice",
    onNavigate: (NavigationEvent) -> Unit,
) {
    var dropdownExpanded: Boolean by remember { mutableStateOf(false) }
    val category = when (postCategory) {
        "Notice" -> "카테고리"
        else -> "문의상품"
    }
    val categoryList: List<String> = when (postCategory) {
        "Notice" -> listOf("지누 티비 트레이", "감자 저지")
        else -> listOf("아크릴 스탠드", "감자 저지")
    }
    var categoryText by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                Text(
                    text = "제목",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = category,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                TextField(
                    state = remember { TextFieldState() },
                    placeholder = {
                        Text(
                            text = "제목을 입력해 주세요",
                            fontSize = 20.sp,
                            color = Color(0xFF999999),
                        )
                    },
                    contentPadding = PaddingValues(0.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                    ),
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        color = Color(0xFF333333)
                    ),
                    modifier = Modifier
                        .width(257.dp)
                        .height(30.dp)
                )
                Box (
                    modifier = Modifier
                        .clickable(
                            onClick = { dropdownExpanded = true }
                        )
                ){
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        Text(
                            text = categoryText?.toString() ?: "카테고리 선택",
                            color = if(categoryText == null){
                                Color(0xFF999999)
                            }else{
                                Color(0xFF333333)
                            },
                            fontSize = 20.sp,
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = null,
                        )
                    }
                    DropdownMenu(
                        expanded = dropdownExpanded,
                        onDismissRequest = { dropdownExpanded = false },
                    ) {
                        categoryList.forEach {
                            DropdownMenuItem(
                                text = { Text(text = it) },
                                onClick = {
                                    categoryText = it
                                    dropdownExpanded = false
                                }
                            )
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            state = rememberTextFieldState(),
            placeholder ={
                Text(
                    text = "공지사항을 작성해 주세요",
                    fontSize = 20.sp,
                    color = Color(0xFF999999),
                )
            },
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .height(452.dp),
            contentPadding = PaddingValues(10.dp),
            textStyle = TextStyle(
                fontSize = 20.sp,
                color = Color(0xFF333333)
            ),
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .align(Alignment.End)
            ){
            Button(
                onClick = {
                    onNavigate(NavigationEvent.NavigationBack)
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFFFFF)
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color(0xFF5C5C5C)
                ),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
            ){
                Text(
                    text = "취소",
                    color = Color(0xFF5C5C5C),
                    fontSize = 20.sp,
                )
            }
            Button(
                onClick = {
                    onNavigate(NavigationEvent.NavigationBack)
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5C5C5C)
                ),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
            ){
                Text(
                    text = "게시",
                    color = Color(0xFFEEEEEE),
                    fontSize = 20.sp,
                )
            }
        }
    }
}