package com.rruiz.contactapp.feature.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material.icons.filled.AccessAlarm
import androidx.compose.material.icons.filled.AppBlocking
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.DoNotDisturb
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rruiz.contactapp.app.core.component.TextFormField


@Composable
@Preview
fun LoginScreen(){

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Scaffold(

    ) {

        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Inicia Sesión",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold

                )
            Spacer(modifier = Modifier.height(10.dp))
                TextFormField(
                    hint = "example@example.com",
                    icon = Icons.Default.Email,
                    iconDescription = "Email",
                    title = "Email",
                    value = email,
                    onValueChange ={
                        value ->
                        email = value
                    }
                )
            Spacer(modifier = Modifier.height(10.dp))
            TextFormField(
                hint = "******",
                icon = Icons.Default.Lock,
                iconDescription = "Password",
                title = "Password",
                value = password,
                onValueChange ={
                        value ->
                    password = value
                }
            )
        }

    }
}