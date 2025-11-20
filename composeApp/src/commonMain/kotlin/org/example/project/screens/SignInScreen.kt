package org.example.project.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.compose_multiplatform
import org.example.project.utill.NavigationEvent
import org.jetbrains.compose.resources.painterResource

@Composable
fun SignInScreen(onNavigate: (NavigationEvent) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {
                onNavigate(NavigationEvent.BaseSignUp)
            }
        ){
            Text("Button")
        }
    }
}