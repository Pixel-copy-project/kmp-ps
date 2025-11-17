package org.example.project.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.components.GoodsComponent
import org.example.project.utill.NavigationEvent
import org.example.project.utill.goodsList

@Composable
fun GoodsListScreen(onNavigate: (NavigationEvent) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(goodsList.size){ index ->
            val goods = goodsList[index]
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.48f)
                    .height(324.dp)
            ) {
                GoodsComponent(
                    goodsImg = goods.imageRes,
                    goodsName = goods.name,
                    goodsDescription = goods.description,
                    goodsPrice = goods.price,
                    modifier = Modifier.fillMaxSize(),
                    quantity = goods.quantity,
                    onNavigate = onNavigate
                )
            }
        }
    }
}