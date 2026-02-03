package org.example.project.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.components.FAQComponent
import org.example.project.viewmodel.FAQViewModel

@Composable
fun FAQScreen(
    faqViewModel: FAQViewModel = viewModel(),
) {
    val faqUiState by faqViewModel.uiState.collectAsState()

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
            faqUiState.faqList.forEach { faq ->
                FAQComponent(
                    question = faq.question,
                    answer = faq.answer,
                )
            }
        }
    }
}