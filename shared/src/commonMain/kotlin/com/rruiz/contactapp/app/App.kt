package com.rruiz.contactapp.app


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.rruiz.contactapp.app.navigation.AppNavigation

@Composable
@Preview
fun App() {
    val navController  = rememberNavController()

    AppNavigation(
        navController = navController
    )
}