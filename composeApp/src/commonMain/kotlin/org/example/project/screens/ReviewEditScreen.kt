package org.example.project.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.good_4
import org.example.project.utill.NavigationEvent
import org.jetbrains.compose.resources.painterResource

@Composable
fun ReviewEditScreen(
    onNavigate: (NavigationEvent) -> Unit,
    reviewItem: String? = null,
){
    var dropdownExpanded: Boolean by remember { mutableStateOf(false) }
    var goodsText by remember { mutableStateOf<String?>(reviewItem) }
    val reviewMaxLength = 120
    Column(
        modifier = Modifier.padding(horizontal = 32.dp)
    ){
        Spacer(modifier = Modifier.height(10.dp))
        Row (
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ){
            Text(
                text = "상품선택",
                fontSize = 20.sp,
            )
            Box(
                modifier = Modifier
                    .clickable(
                        onClick = { dropdownExpanded = true }
                    )
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    Text(
                        text = goodsText?.toString() ?: "카테고리 선택",
                        color = if (goodsText == null) {
                            Color(0xFF999999)
                        } else {
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
                    /*goodsList.forEach {
                        DropdownMenuItem(
                            text = { Text(text = it.name) },
                            onClick = {
                                goodsText = it.name
                                dropdownExpanded = false
                            }
                        )
                    }*/
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(Res.drawable.good_4),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            state = rememberTextFieldState(),
            placeholder ={
                Text(
                    text = "120자 이내로 적어주세요",
                    fontSize = 20.sp,
                    color = Color(0xFF999999),
                )
            },
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(214.dp),
            contentPadding = PaddingValues(10.dp),
            textStyle = TextStyle(
                fontSize = 20.sp,
                color = Color(0xFF333333)
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
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