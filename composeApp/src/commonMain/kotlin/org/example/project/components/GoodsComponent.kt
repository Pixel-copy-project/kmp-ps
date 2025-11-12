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
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmpproject.composeapp.generated.resources.Res
import org.example.project.ui.theme.GoodsDescription
import org.example.project.ui.theme.GoodsName
import org.example.project.ui.theme.GoodsPrice
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun GoodsComponent(
    modifier: Modifier,
    goodsImg: DrawableResource,
    goodsName: String,
    goodsDescription: String,
    goodsPrice: String
) {
    Column (
        modifier = modifier.clickable(
            onClick = {}
        )
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(188.dp)
        ){
            Image(
                painter = painterResource(goodsImg),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
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
            text = goodsPrice,
            fontSize = 18.sp,
            color = GoodsPrice,
            fontWeight = Bold,
            modifier = Modifier
                .padding(top = 8.dp, start = 8.dp, bottom = 8.dp)
        )
    }
}