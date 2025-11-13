package org.example.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.NavigationEvent
import org.example.project.components.CartItemComponent
import org.example.project.ui.theme.AppBackground
import org.example.project.ui.theme.Purple80

@Composable
fun CartScreen(
    onNavigate: (NavigationEvent) -> Unit,
){
    Column(
        modifier = Modifier
            .background(AppBackground)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Spacer(modifier = Modifier.width(18.dp))
            Checkbox(
                checked = false,
                modifier = Modifier
                    .size(48.dp),
                onCheckedChange = {}
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "전체선택",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(3) {
                CartItemComponent(
                    rootModifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(Purple80)
        ){

        }
    }
}