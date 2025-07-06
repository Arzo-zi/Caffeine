package com.example.caffeine.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.presentation.component.FloatingActionButton
import com.example.caffeine.presentation.component.TopBar
import com.example.caffeine.ui.theme.DarkSurface
import kotlinx.coroutines.delay

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues()),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .background(color = Color.White)
                .padding(16.dp)

        ) {
            item {
                TopBar(imgProfile = painterResource(R.drawable.im_profile))
            }
            item {
                TextStars()
            }
            item {
                ImageAnimation(modifier = Modifier)
            }

        }
        FloatingActionButton(
            text = "bring my coffee",
//            TODO
            icon = painterResource(id = R.drawable.coffee),
            onClick = {},
            modifier = Modifier.padding(top = 654.dp, bottom = 50.dp)
        )
    }
}

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
private fun ImageAnimation(modifier: Modifier = Modifier) {

    var up by remember { mutableStateOf(true) }

    val ghostOffset by animateDpAsState(
        targetValue = if (up) (-10).dp else 10.dp,
        animationSpec = tween(durationMillis = 1000),
        label = "Ghost Offset Animation"
    )
    val shadowOffset by animateDpAsState(
        targetValue = if (up) 10.dp else -(10.dp),
        animationSpec = tween(durationMillis = 1000),
        label = "Shadow Offset Animation"
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            up = !up
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            painter = painterResource(R.drawable.img_coffee_ghost),
            contentDescription = stringResource(R.string.coffee_ghost),
            modifier = Modifier
                .size(244.dp)
                .offset(y = ghostOffset)
        )

        Image(
            painter = painterResource(R.drawable.ellipse),
            contentDescription = stringResource(R.string.coffee_ghost),
            modifier = Modifier
                .size(height = 27.dp, width = 200.dp)
                .offset(y = shadowOffset)
        )
    }
}


@Composable
private fun TextStars(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StarIcon(modifier = modifier.offset(x = 90.dp, y = (25).dp))

        Text(
            text = "Hocus\n" +
                    "Pocus\n" +
                    "I Need Coffee\n" +
                    "to Focus",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontSize = 32.sp,
                lineHeight = 50.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.padding(8.dp)
        )

        StarIcon(modifier = modifier.offset(x = (-80).dp, y = -(135).dp))

        StarIcon(modifier = modifier.offset(x = (110).dp, y = -(30).dp))

    }
}

@Composable
private fun StarIcon(
    modifier: Modifier = Modifier
) {
    var visible by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            visible = !visible
        }
    }

    val alpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0.2f,
        animationSpec = tween(
            durationMillis = 100,
            delayMillis = 100,
            easing = { it }
        )
    )

    Icon(
        painter = painterResource(id = R.drawable.ic_text_stars),
        contentDescription = "Coffee Icon",
        tint = DarkSurface,
        modifier = modifier.graphicsLayer {
            this.alpha = alpha
        }

    )
}

@Preview
@Composable
private fun OnboardingScreenPreview() {
    OnboardingScreen()
}