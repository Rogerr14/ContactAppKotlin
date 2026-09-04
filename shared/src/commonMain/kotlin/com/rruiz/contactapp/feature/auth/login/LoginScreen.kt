package com.rruiz.contactapp.feature.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rruiz.contactapp.app.core.component.TextFormField
import contactapp.shared.generated.resources.Res
import contactapp.shared.generated.resources.contact_logo
import org.jetbrains.compose.resources.painterResource


@Composable

fun LoginScreen(
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String)-> Unit,
    onLoginClick: ()-> Unit,
    onRegisterClick: ()-> Unit,
    onForgetPassword: () -> Unit
){
    var obscureText by remember {
        mutableStateOf(false)
    }
    Scaffold() { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 30.dp)
                .fillMaxSize()
                .background(color = Color.White),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(Res.drawable.contact_logo), contentDescription = "Logo Image")
            Text("Welcome back",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text("Please enter your credentials",
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(10.dp))
                TextFormField(
                    hint = "example@example.com",
                    title = "Email",
                    value = uiState.email,
                    onValueChange = onEmailChange
                )
            uiState.emailError?.let { error ->
                Text(
                    text = error,
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            TextFormField(
                hint = "******",
                icon = if (obscureText) {
                    Icons.Default.VisibilityOff
                }else
                {
                    Icons.Default.RemoveRedEye
                },
                iconDescription = "Password",
                title = "Password",
                value = uiState.password,
                onValueChange = onPasswordChange,
                onPressIcon = {
                    obscureText = !obscureText
                }
            )
            uiState.passwordError?.let { error ->
                Text(
                    text = error,
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.
                fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Row(
                    horizontalArrangement = Arrangement.Center
                ){
                    Checkbox(
                        checked = true,
                        onCheckedChange = {},
                        modifier = Modifier.size(15.dp)
                            .scale(0.6f),
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Black
                        )
                    )
                    Text("Remember me",
                        modifier = Modifier.padding(horizontal = 5.dp),
                        fontSize = 12.sp
                    )
                }
                TextButton(
                    onClick = {},
                    modifier = Modifier.padding(),
//                    contentPadding = PaddingValues(
//                        vertical = 0.dp,
//                        horizontal = 4.dp
//                    )
                ){
                    Text("Forgot Password", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                }

            }
            Button(
                onClick = onLoginClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                modifier = Modifier.fillMaxWidth()
            ){
                Text("Sign in")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Text("Don´t have an account?")
                TextButton(
                    onClick = {},
                    contentPadding = PaddingValues(0.dp)

                ){
                    Text("Sign up", color = Color.Black, fontWeight = FontWeight.Bold)
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        uiState = LoginUiState(
            email = "",
            password = ""
        ),
        onEmailChange = {},
        onPasswordChange = {},
        onLoginClick = {},
        onRegisterClick = {},
        onForgetPassword = {}
    )
}