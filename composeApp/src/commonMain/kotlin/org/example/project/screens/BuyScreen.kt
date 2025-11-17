package org.example.project.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.ibk
import kmpproject.composeapp.generated.resources.kb
import kmpproject.composeapp.generated.resources.nh
import kmpproject.composeapp.generated.resources.shinhan
import org.example.project.components.BuyItemComponent
import org.example.project.ui.theme.AppBackground
import org.example.project.utill.NavigationEvent
import org.jetbrains.compose.resources.painterResource

enum class CreditCard{
    KB, NH, SHINHAN, IBK
}

@Composable
fun BuyScreen(
    onNavigate: (NavigationEvent) -> Unit
) {
    var isShow: Boolean by remember { mutableStateOf(true) }
    val paymentMethod: MutableList<Pair<ImageVector, String>> = mutableListOf(
        Pair(Icons.Default.CreditCard, "신용카드"),
        Pair(Icons.Default.CreditCard, "카카오페이"),
        Pair(Icons.Default.CreditCard, "삼성페이"),
        Pair(Icons.Default.CreditCard, "애플페이"),
    )
    var paymentSelected by remember { mutableStateOf(paymentMethod[0]) }
    var creditCardSelected: CreditCard by remember { mutableStateOf(CreditCard.KB) }
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
        ) {
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
                    onClick = { onNavigate(NavigationEvent.NavigateToAddressSelect) },
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
                ) {
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
        ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            onClick = {
                                isShow = !isShow
                            }
                        )
                ) {
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
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier
                            .size(36.dp)
                            .padding(end = 10.dp)
                    )
                }
                if (isShow) {
                    HorizontalDivider(color = Color(0xFF999999))
                    Spacer(modifier = Modifier.height(16.dp))
                    repeat(3) {
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
        ) {
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
                                    paymentSelected = paymentMethod[0]
                                }
                            ),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(Color(0xFF666666)),
                            onClick = { paymentSelected = paymentMethod[0] },
                            selected = paymentSelected == paymentMethod[0],
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
                    if (paymentSelected == paymentMethod[0]) {
                        Spacer(modifier = Modifier.height(18.dp))
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 15.dp)

                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ){
                                Box(
                                    modifier = Modifier
                                        .creditCardStyle(
                                            selectedCreditCard = creditCardSelected,
                                            selectCard = CreditCard.KB,
                                            onSelectCard = {
                                                creditCardSelected = CreditCard.KB
                                            }
                                        )
                                ){
                                    Image(
                                        painter = painterResource(Res.drawable.kb),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .align(Alignment.Center)
                                    )
                                }
                                Box(
                                    modifier = Modifier
                                        .creditCardStyle(
                                            selectedCreditCard = creditCardSelected,
                                            selectCard = CreditCard.NH,
                                            onSelectCard = {
                                                creditCardSelected = CreditCard.NH
                                            }
                                        )
                                ){
                                    Image(
                                        painter = painterResource(Res.drawable.nh),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxSize(0.8f)
                                            .align(Alignment.Center)
                                    )
                                }
                                Box(
                                    modifier = Modifier
                                        .creditCardStyle(
                                            selectedCreditCard = creditCardSelected,
                                            selectCard = CreditCard.SHINHAN,
                                            onSelectCard = {
                                                creditCardSelected = CreditCard.SHINHAN
                                            }
                                        )
                                ){
                                    Image(
                                        painter = painterResource(Res.drawable.shinhan),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .align(Alignment.Center)
                                    )
                                }
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ){
                                Box(
                                    modifier = Modifier
                                        .creditCardStyle(
                                            selectedCreditCard = creditCardSelected,
                                            selectCard = CreditCard.IBK,
                                            onSelectCard = {
                                                creditCardSelected = CreditCard.IBK
                                            }
                                        )
                                ){
                                    Image(
                                        painter = painterResource(Res.drawable.ibk),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .align(Alignment.Center)
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                    Row(
                        modifier = Modifier
                            .clickable(
                                onClick = {
                                    paymentSelected = paymentMethod[1]
                                }
                            ),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(Color(0xFF666666)),
                            onClick = { paymentSelected = paymentMethod[1] },
                            selected = paymentSelected == paymentMethod[1],
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
                                    paymentSelected = paymentMethod[2]
                                }
                            ),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(Color(0xFF666666)),
                            onClick = { paymentSelected = paymentMethod[2] },
                            selected = paymentSelected == paymentMethod[2],
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
                                    paymentSelected = paymentMethod[3]
                                }
                            ),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        RadioButton(
                            colors = RadioButtonDefaults.colors(Color(0xFF666666)),
                            onClick = { paymentSelected = paymentMethod[3] },
                            selected = paymentSelected == paymentMethod[3],
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
        ) {
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

fun Modifier.creditCardStyle(
    selectedCreditCard: CreditCard,
    selectCard: CreditCard,
    onSelectCard:() -> Unit): Modifier{
    return Modifier
        .width(112.dp)
        .height(62.dp)
        .dropShadow(
            shape = RoundedCornerShape(2.dp),
            shadow = Shadow(
                radius = 1.dp,
                spread = 1.dp,
                color = Color(0x40000000),
                offset = DpOffset(x = 0.dp, 2.dp)
            )
        )
        .clip(
            shape = RoundedCornerShape(4.dp)
        )
        .background(color = Color(0xFFF1F1F1))
        .then(
            other = if(selectedCreditCard == selectCard){
                Modifier.border(
                    width = 2.dp,
                    color = Color(0xFF555555),
                    shape = RoundedCornerShape(4.dp)
                )
            }else{
                Modifier
            }
        )
        .padding(8.dp)
        .clickable(
            onClick = {
                onSelectCard()
            }
        )
}