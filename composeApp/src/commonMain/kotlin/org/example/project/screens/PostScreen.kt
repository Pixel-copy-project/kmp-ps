package org.example.project.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
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
import org.example.project.utill.NavigationEvent

@Composable
fun PostScreen(
    title: String,
    postCategory: String,
    tag: String,
    writer: String,
    content: String,
    createdAt: String,
    onNavigate: (NavigationEvent) -> Unit,
){
    var categoryText by remember {
        mutableStateOf<String>(value = when(postCategory){
            "Notice" -> "카테고리"
            else -> "문의상품"
        })
    }

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
                    text = categoryText,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    color = Color(0xFF333333),
                    modifier = Modifier
                        .width(257.dp)
                        .height(30.dp)
                )
                Box{
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        Text(
                            text = tag,
                            color = Color(0xFF333333),
                            fontSize = 20.sp,
                        )
                    }
                }
            }
        }
        HorizontalDivider(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 14.dp)
        )
        Text(
            text = content,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .height(452.dp),
            fontSize = 20.sp,
            color = Color(0xFF333333)
        )
        HorizontalDivider(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 14.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .align(Alignment.Start)
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
                    text = "목록으로",
                    color = Color(0xFF5C5C5C),
                    fontSize = 20.sp,
                )
            }
        }
    }
}