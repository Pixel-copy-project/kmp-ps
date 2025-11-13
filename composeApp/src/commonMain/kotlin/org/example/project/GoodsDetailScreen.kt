package org.example.project

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.NavigationEvent
import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.good_4
import kmpproject.composeapp.generated.resources.package_notice
import kmpproject.composeapp.generated.resources.sold_out
import org.example.project.ui.theme.Purple40
import org.example.project.ui.theme.Purple80
import org.jetbrains.compose.resources.painterResource

@Composable
fun GoodsDetailScreen(
    onNavigate: (NavigationEvent) -> Unit,
    goodsName: String,
    goodsDescription: String,
    goodsPrice: Int,
    quantity: Int,
    ) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(388.dp)
            ){
                Image(
                    painter = painterResource(Res.drawable.good_4),
                    contentDescription = "goods image",
                    modifier = Modifier.fillMaxSize()
                )
                if(quantity <= 0){
                    Image(
                        painter = painterResource(Res.drawable.sold_out),
                        contentDescription = "sold out image",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ){
                Text(
                    text = goodsName,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 4.dp)
                )
                Text(
                    text = formatNumberWithComma(goodsPrice) + "원",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 4.dp)
                )
                Text(
                    text = goodsDescription,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF666666),
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(28.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Center
            ){
                OutlinedButton(
                    onClick = {},
                    shape = RoundedCornerShape(
                        8.dp
                    ),
                    border = BorderStroke(
                        width = 2.dp,
                        color = Color(0xFF999999)
                    ),
                    modifier = Modifier.weight(0.4f)
                ){
                    Text(text = "장바구니")
                }
                Spacer(modifier = Modifier.width(14.dp))
                OutlinedButton(
                    onClick = {},
                    shape = RoundedCornerShape(
                        8.dp
                    ),
                    border = BorderStroke(
                        width = 2.dp,
                        color = Color(0xFF999999)
                    ),
                    modifier = Modifier.weight(0.4f)
                ){
                    Text(text = "구매하기")
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .height(1011.dp)
        ){
            Image(
                painter = painterResource(Res.drawable.package_notice),
                contentDescription = "package notice image",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}