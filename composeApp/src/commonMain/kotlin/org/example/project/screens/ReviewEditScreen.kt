package org.example.project.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.utill.goodsList

@Composable
fun ReviewEditScreen(
    reviewItem: String? = null,
){

    var dropdownExpanded: Boolean by remember { mutableStateOf(false) }
    var goodsText by remember { mutableStateOf<String?>(reviewItem) }
    Column(
        modifier = Modifier.padding(horizontal = 32.dp)
    ){
        Spacer(modifier = Modifier.height(10.dp))
        Row (
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ){
            Text(
                text = "상품선택",
                fontSize = 20.sp,
            )
            Box(
                modifier = Modifier
                    .clickable(
                        onClick = { dropdownExpanded = true }
                    )
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    Text(
                        text = goodsText?.toString() ?: "카테고리 선택",
                        color = if (goodsText == null) {
                            Color(0xFF999999)
                        } else {
                            Color(0xFF333333)
                        },
                        fontSize = 20.sp,
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                    )
                }
                DropdownMenu(
                    expanded = dropdownExpanded,
                    onDismissRequest = { dropdownExpanded = false },
                ) {
                    goodsList.forEach {
                        DropdownMenuItem(
                            text = { Text(text = it.name) },
                            onClick = {
                                goodsText = it.name
                                dropdownExpanded = false
                            }
                        )
                    }
                }
            }
        }
    }
}