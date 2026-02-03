package org.example.project.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.components.PostTitleComponent
import org.example.project.utill.NavigationEvent

@Composable
fun QAScreen(onNavigate: (NavigationEvent) -> Unit) {

    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "문의사항",
            fontSize = 40.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 8.dp),
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ){
            Button(
                onClick = {

                },
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color(0xFF666666)
                ),
                colors = if(false){
                    ButtonDefaults.buttonColors(Color.Black)
                }
                else{
                    ButtonDefaults.buttonColors(Color.White)
                },
            ){
                Text(
                    text = "모두",
                    fontSize = 16.sp,
                    color = if(true){
                        Color(0xFFEEEEEE)
                    }
                    else{
                        Color(0xFF666666)
                    }
                )
            }
            Button(
                onClick = {

                },
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color(0xFF666666)
                ),
                colors = if(false){
                    ButtonDefaults.buttonColors(Color.Black)
                }
                else{
                    ButtonDefaults.buttonColors(Color.White)
                },
            ){
                Text(
                    text = "답변 전",
                    fontSize = 16.sp,
                    color = if(true){
                        Color(0xFFEEEEEE)
                    }
                    else{
                        Color(0xFF666666)
                    }
                )
            }
            Button(
                onClick = {

                },
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color(0xFF666666)
                ),
                colors = if(false){
                    ButtonDefaults.buttonColors(Color.Black)
                }
                else{
                    ButtonDefaults.buttonColors(Color.White)
                }
            ){
                Text(
                    text = "답변 완료",
                    fontSize = 16.sp,
                    color = if(true){
                        Color(0xFFEEEEEE)
                    }
                    else{
                        Color(0xFF666666)
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                /*val filteredList = PostLists.filter{
                    if(tag == null) return@filter true
                    it.tag == tag
                }.sortedByDescending {
                    it.createdAt
                }
                filteredList.take(10).forEach{ it ->
                    PostTitleComponent(
                        category = it.category,
                        tag = it.tag.answer,
                        title = it.title,
                        fontSize = 18,
                        onNavigate = onNavigate
                    )
                }*/
            }
        }
    }
}