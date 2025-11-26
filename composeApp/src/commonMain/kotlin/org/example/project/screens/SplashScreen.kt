package org.example.project.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kmpproject.composeapp.generated.resources.Res
import kmpproject.composeapp.generated.resources.pixel_logo
import kotlinx.coroutines.delay
import org.example.project.ui.theme.AppBackground1
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashScreen(
    onTimeOut: () -> Unit
){
    val currentOnTimeout by rememberUpdatedState(onTimeOut)
    LaunchedEffect(true){
        delay(2000)
        currentOnTimeout()
    }
    Column(
        modifier = Modifier
            .safeContentPadding()
            .background(AppBackground1),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(250.dp))
        Image(
            painter = painterResource(Res.drawable.pixel_logo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}