package org.example.project.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.utill.DisplayAddress
import org.example.project.utill.NavigationEvent
import org.example.project.viewmodel.AddressViewModel

@Composable
fun AddressAppendScreen(
    addressViewModel: AddressViewModel,
    onNavigate: (NavigationEvent) -> Unit
) {
    val addressUiState by addressViewModel.uiState.collectAsState()
    var addressSelected by remember {
        mutableStateOf(addressUiState.addressList.firstOrNull())
    }
    val addressNameState = rememberTextFieldState()
    val detailAddressState = rememberTextFieldState()
    var showError by remember { mutableStateOf(false) }

    LaunchedEffect(addressUiState.addressList) {
        if (addressSelected == null && addressUiState.addressList.isNotEmpty()) {
            addressSelected = addressUiState.addressList.first()
        }
    }

    val address: List<DisplayAddress> = listOf(
        DisplayAddress(
            addressName = "새로운 집",
            addressRoad = "서울시 동대문구 동대로 107-20",
            addressZipCode = "123456",
            addressDetail = "3089동 12호"
        ),
        DisplayAddress(
            addressName = "새로운 집",
            addressRoad = "서울시 동대문구 동대로 107-20",
            addressZipCode = "123456",
            addressDetail = "3089동 12호"
        ),
        DisplayAddress(
            addressName = "새로운 집",
            addressRoad = "서울시 동대문구 동대로 107-20",
            addressZipCode = "123456",
            addressDetail = "3089동 12호"
        ),
        DisplayAddress(
            addressName = "새로운 집",
            addressRoad = "서울시 동대문구 동대로 107-20",
            addressZipCode = "123456",
            addressDetail = "3089동 12호"
        ),
    )

    var showOverlay by remember { mutableStateOf(false) }

    Column(
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            OutlinedTextField(
                state = rememberTextFieldState(),
                placeholder = {
                    Text(
                        text = "경기도 성남시 대왕판교로 머시기 205-1023호",
                        fontSize = 16.sp,
                        color = Color(0xFF666666),
                        maxLines = 1,
                    )
                },
                //colors = TextFieldDefaults.colors(Color.White),
                modifier = Modifier
                    .width(300.dp)
            )
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(0.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color(0xFF666666)
                ),
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 16.dp),
            ) {
                Text(
                    text = "검색",
                    fontSize = 16.sp,
                    color = Color(0xFF666666),
                )
            }
        }
        Box(
            modifier = Modifier.padding(start = 12.dp)
        ) {
            Text(
                text = "상세주소 입력",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
            )
        }
        Spacer(modifier = Modifier.height(22.dp))
        Column(
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            address.forEach { it ->
                Spacer(modifier = Modifier.height(22.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(46.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            onClick = {
                                showOverlay = true
                                addressSelected = it
                            }
                        )
                ) {
                    Column() {
                        Text(
                            text = "도로명 주소",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF666666),
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "우편번호",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF666666),
                        )
                    }
                    Column() {
                        Text(
                            text = it.addressRoad,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF000000),
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = it.addressZipCode,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF000000),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(22.dp))
                HorizontalDivider(modifier = Modifier.fillMaxWidth())
            }
        }
    }
    if (showOverlay) {
        Box(
            modifier = Modifier
                .background(Color(0xAA000000))
                .padding(horizontal = 24.dp)
        ) {
            Box(
                modifier = Modifier
                    .offset(y = 104.dp)
                    .background(Color.White)
            ) {
                IconButton(
                    onClick = { showOverlay = false },
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.TopEnd)
                        .offset(x = (-20).dp ,y = 20.dp)
                ){
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(horizontal = 36.dp, vertical = 14.dp)
                ) {
                    Spacer(modifier = Modifier.height(30.dp))
                    TextField(
                        state = addressNameState,
                        placeholder = {
                            Text(
                                text = "배송지 이름을 입력해 주세요.",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF666666),
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                        isError = addressNameState.text.isBlank() && showError,
                        keyboardOptions = KeyboardOptions.Default,
                        textStyle = LocalTextStyle.current.copy(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                        ),

                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = addressSelected?.addressRoad!!,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        maxLines = 2,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    TextField(
                        state = detailAddressState,
                        placeholder = {
                            Text(
                                text = "상세 주소 입력",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Light,
                                color = Color(0xFF666666),
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                        ),
                        keyboardOptions = KeyboardOptions.Default,
                        isError = detailAddressState.text.isBlank() && showError,
                        textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                    )
                    Spacer(modifier = Modifier.height(70.dp))
                    OutlinedButton(
                        onClick = {
                            if(addressNameState.text.isBlank()){
                                showError = true
                                return@OutlinedButton
                            }
                            addressViewModel.addAddress(
                                newAddress = DisplayAddress(
                                    addressName = addressNameState.text.toString(),
                                    addressRoad = addressSelected?.addressRoad!!,
                                    addressZipCode = addressSelected?.addressZipCode!!,
                                    addressDetail = detailAddressState.text.toString()
                                )
                            )
                            showOverlay = false
                            onNavigate(NavigationEvent.NavigationBack)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White),
                        shape = RoundedCornerShape(0.dp),
                        border = BorderStroke(
                            width = 2.dp,
                            color = Color(0xFF999999)
                        )
                    ) {
                        Text(
                            text = "배송지 추가하기",
                            fontSize = 18.sp,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(vertical = 4.dp)
                        )
                    }
                }
            }
        }
    }
}