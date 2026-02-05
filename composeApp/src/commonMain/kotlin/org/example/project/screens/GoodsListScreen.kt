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

    // 스크롤이 끝에 도달했는지 감지
    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .collect { lastVisibleIndex ->
                if (lastVisibleIndex != null &&
                    lastVisibleIndex >= productUiState.productList.size - 5 && // 끝에서 5개 전에 로드 시작
                    !productUiState.isLoading &&
                    productUiState.error == null
                ) {
                    viewModel.loadProductNextPage()
                }
            }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        state = listState,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if (productUiState.error == null) {
            items(productUiState.productList.size) { index ->
                val goods = productUiState.productList[index]
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.48f)
                        .height(324.dp)
                ) {
                    GoodsComponent(
                        goodsName = goods.name,
                        goodsDescription = goods.description,
                        goodsPrice = goods.price,
                        modifier = Modifier.fillMaxSize(),
                        quantity = goods.quantity,
                        onNavigate = onNavigate,
                        imageName = goods.imageName
                    )
                }
            }

            // 로딩 인디케이터
            if (productUiState.isLoading) {
                item(span = { GridItemSpan(2) }) {
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
        } else {
            item(span = { GridItemSpan(2) }) {
                Text("${productUiState.error}")
            }
        }
    }
}