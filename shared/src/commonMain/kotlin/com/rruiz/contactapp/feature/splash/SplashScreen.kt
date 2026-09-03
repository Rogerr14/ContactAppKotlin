package com.rruiz.contactapp.feature.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import contactapp.shared.generated.resources.Res
import contactapp.shared.generated.resources.contact_logo
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import kotlin.time.Duration.Companion.milliseconds

@Composable
@Preview
fun SplashScreen (
    onFinished: ()-> Unit
) {

    var showImage by remember{
        mutableStateOf(false)
    }

    val imageAlpha by animateFloatAsState(
        targetValue = if(showImage) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000
        ),
        label = "imageAlpha"
    )

    LaunchedEffect(Unit){
        delay(500.milliseconds)
        showImage = true
        delay(2000.milliseconds)
        onFinished()
    }

    Scaffold(modifier = Modifier.background(color = Color.Red)) {
        Column(modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

            AnimatedVisibility(
                visible = showImage,
                enter = fadeIn(
                    animationSpec = tween(1000)

                )+ slideInHorizontally(
                    animationSpec = tween(1000),
                    initialOffsetX = {
                        fullWidth -> -fullWidth
                    }

                )
            ){
                Text(text = "Bienvenido a ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp,
                    fontFamily = FontFamily.Monospace)
            }



                Image(
                    modifier = Modifier
                    .size(160.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(20.dp))
                        .graphicsLayer(alpha = imageAlpha),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(Res.drawable.contact_logo), contentDescription = "Logo")

            AnimatedVisibility(
                visible = showImage,
                enter = fadeIn(
                    animationSpec = tween(1000)
                ) + slideInHorizontally(
                    animationSpec = tween(1000),
                    initialOffsetX = {
                        it
                    }

                )
            ){
                Text("Tu agenda personal",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    fontFamily = FontFamily.Monospace)

            }
            }
    }
}