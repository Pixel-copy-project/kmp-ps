package org.example.project.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.ui.theme.AppBackground
import org.example.project.utill.NavigationEvent

@Composable
fun AddressSelectScreen(
    onNavigate: (NavigationEvent) -> Unit,
) {
    val addressList: List<Pair<String, String>> =
        listOf(
            Pair("우리집", "경기도 평택시 중앙로 20-102로 3000동 7543호"),
            Pair("자취방", "경기도 평택시 중앙로 20-102로 3000동 7543호"),
            Pair("사무실", "경기도 평택시 중앙로 20-102로 3000동 7543호")
        )
    var addressSelected by remember { mutableStateOf(addressList[0]) }

    Column(
        modifier = Modifier
            .background(AppBackground)
    ) {
        Spacer(modifier = Modifier.height(14.dp))
        Row(
            modifier = Modifier
                .align(Alignment.End)
        ) {
            IconButton(
                onClick = {
                    onNavigate(NavigationEvent.NavigateToAddressAppend)
                },
                modifier = Modifier.size(32.dp)
            ) {
                Image(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(24.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(414.dp)
                .padding(12.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                addressList.forEach { it ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(122.dp)
                            .background(Color.White)
                    ) {
                        Row(
                            modifier = Modifier
                                .clickable(onClick = {
                                    addressSelected = it
                                }),
                            horizontalArrangement = Arrangement.spacedBy(22.dp),
                        ) {
                            RadioButton(
                                onClick = {
                                    addressSelected = it
                                },
                                selected = addressSelected == it,
                                colors = RadioButtonDefaults.colors(Color.Black),
                                modifier = Modifier
                                    .weight(0.1f)
                                    .align(Alignment.CenterVertically)
                            )
                            Column(
                                modifier = Modifier
                                    .padding(top = 12.dp)
                                    .weight(0.8f),
                                verticalArrangement = Arrangement.spacedBy(16.dp),
                            ) {
                                Text(
                                    text = it.first,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                                Text(
                                    text = it.second,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color(0xFF666666),
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .weight(0.1f)
                            ) {
                                IconButton(
                                    onClick = {},
                                    modifier = Modifier
                                        .size(28.dp)
                                        .offset(y = 8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.Edit,
                                        contentDescription = null,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(182.dp))
        OutlinedButton(
            onClick = {
                onNavigate(NavigationEvent.NavigationBack)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .background(Color.White),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(
                width = 2.dp,
                color = Color(0xFF999999)
            )
        ) {
            Text(
                text = "선택",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(vertical = 4.dp)
            )
        }
    }
}