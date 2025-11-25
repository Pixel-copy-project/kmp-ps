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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.ui.theme.AppBackground
import org.example.project.utill.NavigationEvent
import org.example.project.viewmodel.AddressViewModel

@Composable
fun AddressSelectScreen(
    onNavigate: (NavigationEvent) -> Unit,
    addressViewModel: AddressViewModel
) {
    val addressUiState by addressViewModel.uiState.collectAsState()
    var addressSelected by remember {
        mutableStateOf(addressUiState.addressList.firstOrNull())
    }

    LaunchedEffect(addressUiState.addressList) {
        if (addressSelected == null && addressUiState.addressList.isNotEmpty()) {
            addressSelected = addressUiState.addressList.first()
        }
    }

    if(addressUiState.isLoading){
        Text("Loading....")
    }
    else if(addressUiState.addressList.isEmpty()){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(AppBackground)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(200.dp))
            Text(
                text = "배송지를 추가해서 주문해보세요!",
                fontSize = 20.sp,
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedButton(
                onClick = {
                    onNavigate(NavigationEvent.NavigateToAddressAppend)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 72.dp)
                    .background(Color.White),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(
                    width = 2.dp,
                    color = Color(0xFF999999)
                )
            ) {
                Text(
                    text = "배송지 추가",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(vertical = 4.dp)
                )
            }
        }
    } else {
        Column() {
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
                    .padding(12.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    addressUiState.addressList.forEach { it ->
                        println("AddressSelectScreen: $it")
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(122.dp)
                                .background(Color.White)
                        ) {
                            Row(
                                modifier = Modifier
                                    .clickable(onClick = {
                                        addressViewModel.selectAddress(it)
                                    }),
                                horizontalArrangement = Arrangement.spacedBy(22.dp),
                            ) {
                                RadioButton(
                                    onClick = {
                                        addressViewModel.selectAddress(it)
                                    },
                                    selected = addressUiState.selectedAddress === it,
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
                                    println("AddressSelectScreen: ${it.addressName}")
                                    Text(
                                        text = it.addressName,
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                    println("AddressSelectScreen: ${it.addressDetail}")
                                    Text(
                                        text = "${it.addressRoad} ${it.addressDetail}",
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
}