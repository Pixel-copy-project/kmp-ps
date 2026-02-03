package org.example.project.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.ui.theme.AppBackground0

@Composable
fun FAQComponent(
    question: String,
    answer: String,
) {
    var isOpenAnswer by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .background(AppBackground0)
            .clickable(
                onClick = { isOpenAnswer = !isOpenAnswer }
            ),
    ){

        Spacer(modifier = Modifier.height(14.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text(text = "Q. ",
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(
                        top = 4.dp,
                        start = 14.dp
                    )
            )
            Text(
                text = question,
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                modifier = Modifier
                    .width(300.dp)
            )
            Icon(
                imageVector =
                    if(isOpenAnswer){
                        Icons.Default.KeyboardArrowUp
                    }
                    else{
                        Icons.Default.KeyboardArrowDown
                    },
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        if(isOpenAnswer){
            Text(
                text = answer,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .width(352.dp)
                    .padding(start = 24.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

    }
}