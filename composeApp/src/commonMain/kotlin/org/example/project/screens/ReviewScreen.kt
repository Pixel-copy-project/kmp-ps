package org.example.project.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.components.GoodsReviewComponent
import org.example.project.utill.NavigationEvent

@Composable
fun ReviewScreen(onNavigate: (NavigationEvent) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 12.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                IconButton(
                    onClick = {
                        onNavigate(
                            NavigationEvent.NavigateToReviewEdit()
                        )
                    },
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.CenterEnd)
                        .offset(x = (-33).dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(
                        vertical = 16.dp, horizontal = 6.dp
                    )
            )
        }
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(3) {
                    GoodsReviewComponent(
                        reviewContent = "본문 내용 전체 다 나오는 본문 내용 전체 다 나오는본문 내용 전체 다 나오는본문 내용 전체 다 나오는본문 내용 전체 다 나오는본문 내용 전체 다 나오는본문 내용 전체 다 나오는본문 내용 전체 다 나오는본문 내용 전체 다 나오는본문 내용 전체 다 나오는",
                    )
                }
            }
        }
    }
}