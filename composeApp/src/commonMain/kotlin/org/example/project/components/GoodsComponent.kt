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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
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
    Column (
        modifier = modifier.clickable(
            onClick = {
                onNavigate(NavigationEvent.NavigateToGoodsDetail(
                    goodsName = goodsName,
                    goodsDescription = goodsDescription,
                    goodsPrice = goodsPrice,
                    quantity = quantity,
                    imageName = imageName,
                    )
                )
            }
        )
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(188.dp)
        ){
            Image(
                painter = painterResource(DrawableMapper.getDrawable(imageName)),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
            if(quantity <= 0){
                Image(
                    painter = painterResource(Res.drawable.sold_out),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
        Text(
            text = goodsName,
            fontSize = 18.sp,
            color = GoodsName,
            fontWeight = Bold,
            modifier = Modifier
                .padding(top = 8.dp, start = 8.dp)
        )
        Text(
            text = goodsDescription,
            color = GoodsDescription,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(top = 8.dp, start = 8.dp)
        )
        Text(
            text = formatNumberWithComma(goodsPrice) + "원",
            fontSize = 18.sp,
            color = GoodsPrice,
            fontWeight = Bold,
            modifier = Modifier
                .padding(top = 8.dp, start = 8.dp, bottom = 8.dp)
        )
    }
}