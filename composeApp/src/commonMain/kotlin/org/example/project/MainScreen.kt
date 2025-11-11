package org.example.project

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.NavigationEvent
import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.compose_multiplatform
import org.example.project.ui.theme.Grey40
import org.example.project.ui.theme.Purple40
import org.example.project.ui.theme.Purple80
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainScreen(onNavigate: (NavigationEvent) -> Unit) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(Grey40)
            .verticalScroll(state = scrollState)
    ) {
        /* Banner */
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp)
                .height(194.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
            Row(

            ){

            }
        }

        /* Notice */
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 12.dp, end = 12.dp)
                .height(138.dp)
                .background(Purple80)
        ) {
            Row(){
                Box(
                    modifier = Modifier
                        .weight(0.4f)
                ){
                    Text(
                        text = "공지사항\nNotice",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(0.6f)
                ){
                    Text(
                        text = "공지사항 영역",
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
        }

        /* New Goods */
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 12.dp, end = 12.dp)
                .background(Purple80)
        ) {
            Text(
                text = "새로 나왔어요!",
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
            Spacer(modifier = Modifier.height(21.dp))
            FlowRow(

            ){
                repeat(3) {
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White,
                            disabledContainerColor = Color.Black,
                            disabledContentColor = Color.White
                        ),
                        modifier = Modifier
                            .padding(start = 4.dp, end = 4.dp)
                    ){
                        Text(
                            text = "카테고리"
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .height(324.dp)
            ){
                Box(
                    modifier = Modifier
                        .weight(0.48f)
                        .fillMaxHeight()
                        .background(Purple40)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Box(
                    modifier = Modifier
                        .weight(0.48f)
                        .fillMaxHeight()
                        .background(Purple40)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .height(324.dp)
            ){
                Box(
                    modifier = Modifier
                        .weight(0.48f)
                        .fillMaxHeight()
                        .background(Purple40)

                )
                Spacer(modifier = Modifier.width(12.dp))
                Box(
                    modifier = Modifier
                        .weight(0.48f)
                        .fillMaxHeight()
                        .background(Purple40)

                )
            }
            Spacer(modifier = Modifier.height(48.dp))
            OutlinedButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.8f),
                onClick = {

                },
                shape = RoundedCornerShape(
                    8.dp
                ),
                border = BorderStroke(
                    width = 2.dp,
                    color = Color(0x666666FF)
                )
            ){
                Row {
                    Text(
                        text = "더 많은 상품 보러가기"
                    )
                    Icon(
                        imageVector =  Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(233.dp)
                .padding(top = 54.dp, start = 12.dp, end = 12.dp)
                .background(Purple80)
        ){

        }
        Spacer(modifier = Modifier.height(56.dp))
    }

}