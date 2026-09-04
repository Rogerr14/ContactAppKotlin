package com.rruiz.contactapp.app.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
    icon: ImageVector? = null,
    iconDescription: String? = null,
    onPressIcon: ()-> Unit = {},
    onValueChange: (String) -> Unit,
    obscureText: Boolean = false
){
    Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
            ){
        Text(title, fontSize = 12.sp, fontWeight = FontWeight.Normal, color = Color.Gray)
        BasicTextField(
            value= value,
            singleLine = true,
            onValueChange = onValueChange,

            modifier = Modifier.
                        fillMaxWidth()
                .height(40.dp)
                .background(
                    color = Color(0xFFe5e5e5),
                    shape = RoundedCornerShape(5.dp)
                ),
            decorationBox = {
                innerTextField ->
                Row(
                    modifier =  Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box(
                        modifier = Modifier.weight(1f)
                    ){
                        if (value.isEmpty()){
                            Text(
                                text = hint,
                                color = Color.Gray
                            )
                        }
                        innerTextField()
                    }
                   if(icon != null ) {
                       IconButton(
                            onClick = onPressIcon,
                            shape = RoundedCornerShape(10.dp),
                           modifier = Modifier.size(20.dp)
                       ){
                           Icon(icon, contentDescription = iconDescription)
                       }

                   }
                }
            }

        )

    }
}