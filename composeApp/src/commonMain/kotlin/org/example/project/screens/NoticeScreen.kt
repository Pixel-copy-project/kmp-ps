package org.example.project.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.components.PostTitleComponent
import org.example.project.ui.theme.AppBackground0
import org.example.project.utill.NavigationEvent
import org.example.project.viewmodel.PostViewModel

@Composable
fun NoticeScreen(
    onNavigate: (NavigationEvent) -> Unit,
    postViewModel: PostViewModel = viewModel()
) {
    val postUiState by postViewModel.postListUiState.collectAsState()

    Column(
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        Spacer(modifier = Modifier.height(18.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(AppBackground0)
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ){
            Column {
                Text(
                    text = "새로 올라온 공지",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Medium,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                ){
                    postUiState.postList.take(4).forEach { it ->
                        PostTitleComponent(
                            category = it.category,
                            tag = it.tag,
                            title = it.title,
                            fontSize = 16,
                            author = it.author,
                            content = it.content,
                            onNavigate = onNavigate
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp)
                .padding(horizontal = 6.dp)
                .background(Color.White)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ){
                OutlinedTextField(
                    state = rememberTextFieldState(),
                    placeholder ={
                        Text(
                            text = "제목을 입력하세요",
                            fontSize = 14.sp,
                            color = Color(0xFF666666),
                        )
                    },
                    shape = RoundedCornerShape(0.dp),
                    modifier = Modifier
                        .width(327.dp)
                        .fillMaxHeight(),
                    contentPadding = PaddingValues(0.dp)
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .border(width = 1.dp, color = Color.Black)
                        .width(36.dp)
                        .fillMaxHeight()
                ){
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                postUiState.postList.take(10).forEach{ it ->
                    PostTitleComponent(
                        category = it.category,
                        tag = it.tag,
                        title = it.title,
                        fontSize = 18,
                        author = it.author,
                        content = it.content,
                        onNavigate = onNavigate
                    )
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ){
            val page = (postUiState.postList.size / 10) + 1
            for(i in 1..page){
                TextButton(
                    onClick = {},
                ){
                    Text("$i")
                }
            }
        }
    }
}