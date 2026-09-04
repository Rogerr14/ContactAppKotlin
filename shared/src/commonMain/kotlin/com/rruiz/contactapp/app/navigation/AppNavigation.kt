package com.rruiz.contactapp.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rruiz.contactapp.feature.auth.login.LoginScreen
import com.rruiz.contactapp.feature.splash.SplashScreen
import androidx.navigationevent.compose.rememberNavigationEventState
import androidx.navigationevent.NavigationEventInfo
import androidx.navigationevent.compose.NavigationBackHandler
import com.rruiz.contactapp.feature.auth.login.LoginEntry

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = SplashRoute
    ){

        composable<SplashRoute>{
            SplashScreen(
                onFinished = {
                    navController.navigate(LoginRoute){
                        popUpTo<SplashRoute> {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable<LoginRoute> {
            val backState = rememberNavigationEventState(
               currentInfo =  NavigationEventInfo.None
            )

            NavigationBackHandler(
                state = backState,
                isBackEnabled = true,
                onBackCompleted = {

                }
            )
            LoginEntry()
        }
    }
}