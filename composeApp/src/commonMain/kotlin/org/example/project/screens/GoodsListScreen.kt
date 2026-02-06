package org.example.project.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.components.GoodsComponent
import org.example.project.utill.NavigationEvent
import org.example.project.viewmodel.ProductViewModel

@Composable
fun GoodsListScreen(
    onNavigate: (NavigationEvent) -> Unit,
    viewModel: ProductViewModel = viewModel()
) {
    val productUiState by viewModel.uiState.collectAsState()
    val listState = rememberLazyGridState()

    // 스크롤 감지 최적화
    LaunchedEffect(listState) {
        snapshotFlow {
            listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
        }
            .collect { lastVisibleIndex ->
                val threshold = productUiState.productList.size - 5
                if (lastVisibleIndex != null &&
                    lastVisibleIndex >= threshold &&
                    !productUiState.isLoading &&
                    productUiState.hasMorePage // 이 체크가 중요!
                ) {
                    viewModel.loadProductNextPage()
                }
            }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        state = listState,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(12.dp) // 여기서 패딩 처리
    ) {
        // ✅ key를 사용하여 아이템 재사용 최적화
        items(
            count = productUiState.productList.size,
            key = { index -> productUiState.productList[index].id } // 고유 ID 사용
        ) { index ->
            val goods = productUiState.productList[index]

            // Box 제거하고 직접 컴포넌트 사용
            GoodsComponent(
                goodsName = goods.name,
                goodsDescription = goods.description,
                goodsPrice = goods.price,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(324.dp),
                quantity = goods.quantity,
                onNavigate = onNavigate,
                imageName = goods.imageName
            )
        }

        // 로딩 인디케이터
        if (productUiState.isLoading && productUiState.productList.isNotEmpty()) {
            item(
                key = "loading",
                span = { GridItemSpan(2) }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }

        // 에러 처리
        if (productUiState.error != null) {
            item(
                key = "error",
                span = { GridItemSpan(2) }
            ) {
                Text(
                    text = "오류: ${productUiState.error}",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}