package org.example.project.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.components.FAQComponent

@Composable
fun FAQScreen() {
    Column (
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 12.dp)
    ){
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "자주하는 질문",
            fontSize = 40.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 12.dp),
        )
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            repeat(5) {
                FAQComponent()
            }
        }
    }
}