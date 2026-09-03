package com.rruiz.contactapp.app.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource


@Composable
fun TextFormField(
    title: String,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    obscureText: Boolean = false
){
    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ){
        Text(title, fontSize = 15.sp, fontWeight = FontWeight.Bold)
        BasicTextField(
            value= value,
            singleLine = true,
            onValueChange = onValueChange,
            modifier = Modifier.
                        fillMaxWidth()
                .height(54.dp)
                .background(
                    color = Color(0xFF8ecae6),
                    shape = RoundedCornerShape(20.dp)

                ),
            decorationBox = {
                innerTextField ->
                Row(
                    modifier =  Modifier
                        .fillMaxWidth()
                        .background(
                        color =  Color(0xFF8ecae6),
                        shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){

                }
            }

        )

    }
}