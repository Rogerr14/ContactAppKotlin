package com.rruiz.contactapp.feature.auth.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rruiz.contactapp.app.core.component.TextFormField

@Composable
@Preview
fun RegisterScreen(){
    var nombres by remember{
        mutableStateOf("")
    }
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)

        ){
            Text("Registrate")
            Spacer(modifier = Modifier.padding(vertical = 20.dp))
            TextFormField(
                title = "Nombres",
                value = nombres,
                hint = "Nombres completos",
                icon = Icons.Default.Person,
                iconDescription = "Nombres",
                onValueChange = {
                    value -> nombres = value
                }
            )
            Spacer(modifier = Modifier.padding(vertical = 20.dp))

        }
    }
}