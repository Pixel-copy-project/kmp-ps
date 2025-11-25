package org.example.project.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.goods_1
import org.example.project.formatNumberWithComma
import org.example.project.utill.DisplayGoodsItem
import org.example.project.viewmodel.CartViewModel
import org.jetbrains.compose.resources.painterResource

@Composable
fun CartItemComponent(
    rootModifier: Modifier = Modifier,
    cartViewModel: CartViewModel,
    goodsItem: DisplayGoodsItem,
    removeItem: (DisplayGoodsItem) -> Unit
) {
    var select by remember { mutableStateOf(true) }
    val uiState by cartViewModel.uiState.collectAsState()
    Box(
        modifier = rootModifier
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Row() {
                Spacer(modifier = Modifier.width(6.dp))
                Checkbox(
                    checked = select,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(48.dp),
                    onCheckedChange = {
                        select = !select
                        if(select) cartViewModel.addFinalItem(goodsItem) else cartViewModel.removeFinalItem(goodsItem)
                        println(uiState.finalOrderList.size)
                    },
                )
                Image(
                    painter = painterResource(Res.drawable.goods_1),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .size(80.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, top = 12.dp),
                ) {
                    Text(
                        text = goodsItem.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF666666),
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = goodsItem.description,
                        fontSize = 14.sp,
                        modifier = Modifier.width(204.dp)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(modifier = Modifier.width(51.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ){
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Text(
                        text = "1",
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                    )
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
                Spacer(modifier = Modifier.width(100.dp))
                Text(
                    text = "${formatNumberWithComma(goodsItem.price)}원",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
        IconButton(
            modifier = Modifier
                .size(30.dp)
                .align(Alignment.TopEnd)
                .padding(top = 12.dp, end = 12.dp),
            onClick = {
                cartViewModel.removeItem(goodsItem)
            },
        ){
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}