package org.example.project.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.sold_out
import org.example.project.formatNumberWithComma
import org.example.project.ui.theme.GoodsDescription
import org.example.project.ui.theme.GoodsName
import org.example.project.ui.theme.GoodsPrice
import org.example.project.utill.DrawableMapper
import org.example.project.utill.NavigationEvent
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun GoodsComponent(
    modifier: Modifier,
    goodsName: String,
    goodsDescription: String,
    goodsPrice: Int,
    quantity: Int,
    imageName: String,
    onNavigate: (NavigationEvent) -> Unit
) {
    // ✅ 모든 연산과 상태를 remember로 캐싱
    val drawable = remember(imageName) {
        DrawableMapper.getDrawable(imageName)
    }
    val imagePainter = painterResource(drawable)

    val priceText = remember(goodsPrice) {
        formatNumberWithComma(goodsPrice) + "원"
    }

    // ✅ onClick을 최상위에서 한 번만 생성
    val onClick = remember(imageName) {
        {
            onNavigate(
                NavigationEvent.NavigateToGoodsDetail(
                    goodsName = goodsName,
                    goodsDescription = goodsDescription,
                    goodsPrice = goodsPrice,
                    quantity = quantity,
                    imageName = imageName,
                )
            )
        }
    }

    Column(
        modifier = modifier
            .clickable(onClick = onClick)
    ) {
        // ✅ Box도 remember로 감싸기
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(188.dp)
        ) {
            Image(
                painter = imagePainter,
                contentDescription = goodsName,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // ✅ 조건을 remember로 캐싱
            if (remember(quantity) { quantity <= 0 }) {
                val soldOutPainter = painterResource(Res.drawable.sold_out)
                Image(
                    painter = soldOutPainter,
                    contentDescription = "품절",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Text(
            text = goodsName,
            fontSize = 18.sp,
            color = GoodsName,
            fontWeight = Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 8.dp, start = 8.dp)
        )

        Text(
            text = goodsDescription,
            color = GoodsDescription,
            fontSize = 14.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 8.dp, start = 8.dp)
        )

        Text(
            text = priceText,
            fontSize = 18.sp,
            color = GoodsPrice,
            fontWeight = Bold,
            modifier = Modifier.padding(top = 8.dp, start = 8.dp, bottom = 8.dp)
        )
    }
}