package org.example.project.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.goods_1
import org.example.project.utill.NavigationEvent
import org.jetbrains.compose.resources.painterResource

@Composable
fun GoodsReviewComponent(
    reviewContent: String,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(116.dp)
            .padding(8.dp)
            .background(Color.White)
            .clickable(
                onClick = {

                }
            )
    ) {
        Image(
            painter = painterResource(Res.drawable.goods_1),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(
                text = reviewContent,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF444444),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(0.75f),
            )
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(2.dp),
                contentPadding = PaddingValues(horizontal = 8.dp),
                colors = ButtonDefaults.textButtonColors(Color(0xFF333333)),
                modifier = Modifier.weight(0.25f),
            ) {
                Text(
                    text = "상품 보러가기",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                )
            }
        }
    }
}