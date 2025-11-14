package org.example.project

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Keyboard
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.NavigationEvent
import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.goods_1
import org.example.project.components.BuyItemComponent
import org.example.project.ui.theme.AppBackground
import org.example.project.ui.theme.Purple80
import org.jetbrains.compose.resources.painterResource

@Composable
fun BuyScreen(
    onNavigate: (NavigationEvent) -> Unit
){
    var isShow: Boolean by remember{ mutableStateOf(true)}
    val paymentMethod: MutableList<Pair<ImageVector, String>> = mutableListOf(
        Pair(Icons.Default.CreditCard, "신용카드"),
        Pair(Icons.Default.CreditCard, "카카오페이"),
        Pair(Icons.Default.CreditCard, "삼성페이"),
        Pair(Icons.Default.CreditCard, "애플페이"),
    )
    var selectedOption by remember { mutableStateOf(paymentMethod[0]) }

    Column(
        modifier = Modifier
            .background(AppBackground)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(Color.White)
        ){
            Column {
                Spacer(modifier = Modifier.height(18.dp))
                Text(
                    text = "배송지 정보",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 20.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "경기도 성남시 대왕판교로 105-231 A동 1406호",
                    fontSize = 14.sp,
                    color = Color(0xFF666666),
                    modifier = Modifier.padding(start = 20.dp)
                )
                Spacer(modifier = Modifier.height(36.dp))
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    border = BorderStroke(
                        width = 1.dp,
                        color = Color(0xFF999999)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .padding(start = 12.dp, end = 12.dp)
                ){
                    Text(
                        text = "배송지 선택 · 추가",
                        fontSize = 16.sp,
                        color = Color.Black,
                    )
                }
                Spacer(modifier = Modifier.height(18.dp))
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(Color.White)
        ){
            Column {
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            onClick = {
                                isShow = !isShow
                            }
                        )
                ){
                    Text(
                        text = "주문할 상품",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(
                            start = 20.dp,
                            top = 20.dp,
                            bottom = 20.dp
                        )
                    )
                    Icon(
                        imageVector =  Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier
                            .size(36.dp)
                            .padding(end = 10.dp)
                    )
                }
                if(isShow){
                    HorizontalDivider(color = Color(0xFF999999))
                    Spacer(modifier = Modifier.height(16.dp))
                    repeat(3){
                        BuyItemComponent(
                            rootModifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(Color.White)
        ){
            Column(

            ) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "결제 수단 선택",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 20.dp)
                )
                Spacer(modifier = Modifier.height(14.dp))
                Column {
                    Row(
                        modifier = Modifier
                            .clickable(
                              onClick = {
                                selectedOption = paymentMethod[0]
                              }
                            ),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        RadioButton(
                            colors = RadioButtonDefaults.colors(Color(0xFF666666)),
                            onClick = { selectedOption = paymentMethod[0] },
                            selected = selectedOption == paymentMethod[0],
                            )
                        Icon(
                            imageVector = Icons.Default.CreditCard,
                            contentDescription = "Credit Card",
                            modifier = Modifier.size(32.dp)
                        )
                        Text(
                            text = "신용카드",
                            fontSize = 20.sp,
                            color = Color(0xFF666666),
                        )
                    }
                    if(selectedOption == paymentMethod[0]){
                        Spacer(modifier = Modifier.height(18.dp))
                        FlowRow(
                            maxItemsInEachRow = 3,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp)
                        ){
                            repeat(4){
                                Box(
                                    modifier = Modifier
                                        .width(114.dp)
                                        .height(72.dp)
                                        .padding(8.dp)
                                        .background(Color.Black)
                                ){
                                    /*Image(
                                        painter = painterResource(Res.drawable.goods_1),
                                        contentDescription = null,
                                    )*/
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                    Row(
                        modifier = Modifier
                            .clickable(
                                onClick = {
                                    selectedOption = paymentMethod[1]
                                }
                            ),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        RadioButton(
                            colors = RadioButtonDefaults.colors(Color(0xFF666666)),
                            onClick = { selectedOption = paymentMethod[1] },
                            selected = selectedOption == paymentMethod[1],
                        )
                        Icon(
                            imageVector = Icons.Default.CreditCard,
                            contentDescription = "Credit Card",
                            modifier = Modifier.size(32.dp)
                        )
                        Text(
                            text = "카카오페이",
                            fontSize = 20.sp,
                            color = Color(0xFF666666),
                        )
                    }
                    Row(
                        modifier = Modifier
                            .clickable(
                                onClick = {
                                    selectedOption = paymentMethod[2]
                                }
                            ),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        RadioButton(
                            colors = RadioButtonDefaults.colors(Color(0xFF666666)),
                            onClick = { selectedOption = paymentMethod[2] },
                            selected = selectedOption == paymentMethod[2],
                        )
                        Icon(
                            imageVector = Icons.Default.CreditCard,
                            contentDescription = "Credit Card",
                            modifier = Modifier.size(32.dp)
                        )
                        Text(
                            text = "애플페이",
                            fontSize = 20.sp,
                            color = Color(0xFF666666),
                        )
                    }
                    Row(
                        modifier = Modifier
                            .clickable(
                                onClick = {
                                    selectedOption = paymentMethod[3]
                                }
                            ),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        RadioButton(
                            colors = RadioButtonDefaults.colors(Color(0xFF666666)),
                            onClick = { selectedOption = paymentMethod[3] },
                            selected = selectedOption == paymentMethod[3],
                        )
                        Icon(
                            imageVector = Icons.Default.CreditCard,
                            contentDescription = "Credit Card",
                            modifier = Modifier.size(32.dp)
                        )
                        Text(
                            text = "삼성페이",
                            fontSize = 20.sp,
                            color = Color(0xFF666666),
                        )
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ){
            TextButton(
                onClick = { onNavigate(NavigationEvent.NavigateToBuy) },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "55,000원 구매하기",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}