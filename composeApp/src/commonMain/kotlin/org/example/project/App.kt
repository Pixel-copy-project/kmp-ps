package org.example.project

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.screens.ContentRoot
import org.example.project.screens.SplashScreen
import org.example.project.utill.AppNav

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    onNavHostReady: suspend (NavController) -> Unit = {}
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppNav.Splash
    ){
        composable<AppNav.Splash>{
            SplashScreen(
                onTimeOut = {
                    navController.navigate(AppNav.ContentRoot){
                        popUpTo(AppNav.Splash) { inclusive = true }
                    }
                }
            )
        }
        composable<AppNav.ContentRoot>{
            ContentRoot(
                onNavHostReady = onNavHostReady
            )
        }
    }

}