package com.example.caffeine.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.caffeine.R
import com.example.caffeine.presentation.component.CoffeeSize
import com.example.caffeine.presentation.component.CupSize
import com.example.caffeine.presentation.component.FloatingActionButton
import com.example.caffeine.presentation.component.TopBar
import com.example.caffeine.ui.theme.LightPrimary60

@SuppressLint("UnusedContentLambdaTargetStateParameter")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToLoadingScreen: ()-> Unit,
    topBarTitle: String,
) {
    var selectedCupSize by remember { mutableStateOf("M") }
    var coffeeDropTrigger by remember { mutableStateOf(false) }
    val sizeDimensions = mapOf(
        "S" to Pair(180.dp, 120.dp),
        "M" to Pair(244.dp, 160.dp),
        "L" to Pair(300.dp, 200.dp)
    )
    val coffeeVolume = mapOf(
        "S" to "150 ML",
        "M" to "200 ML",
        "L" to "400 ML"
    )
    val targetHeight = sizeDimensions[selectedCupSize]?.first ?: 244.dp
    val targetWidth = sizeDimensions[selectedCupSize]?.second ?: 160.dp

    val animatedHeight by animateDpAsState(
        targetValue = targetHeight,
        animationSpec = tween(durationMillis = 600, easing = FastOutLinearInEasing)
    )
    val animatedWidth by animateDpAsState(
        targetValue = targetWidth,
        animationSpec = tween(600, easing = FastOutLinearInEasing),
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.padding(vertical = 16.dp)
    ) {
        TopBar(
            topBarTitle = topBarTitle,
            icon = painterResource(R.drawable.ic_arrow_left),
            modifier = Modifier.padding(16.dp),
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(top = 65.dp, bottom = 76.dp)
        ) {
            this@Column.AnimatedVisibility(
                visible = coffeeDropTrigger,
                enter = slideInVertically(
                    initialOffsetY = { -900 },
                    animationSpec = tween(800, easing = FastOutSlowInEasing)
                ) ,
                exit = slideOutVertically(
                    targetOffsetY = { -900 },
                    animationSpec = tween(800, easing = FastOutSlowInEasing)
                ),

                modifier = Modifier.zIndex(-1f)
            ) {
                Image(
                    painter = painterResource(R.drawable.coffee_dropped),
                    contentDescription = "Coffee Beans Drop",
                    modifier = Modifier.size(90.dp)
                )
            }
            Image(
                painter = painterResource(R.drawable.im_coffee_cup),
                contentDescription = "",
                modifier = Modifier
                    .height(animatedHeight)
                    .width(animatedWidth)
                    .zIndex(0f)
            )
            Image(
                painter = painterResource(R.drawable.img_coffee_logo),
                contentDescription = "",
                modifier = Modifier
                    .size(64.dp)
                    .zIndex(1f)
            )
        }

        AnimatedContent(
            targetState = coffeeVolume[selectedCupSize] ?: "",
            label = "VolumeChange"
        ) { volume ->
            Box(
                modifier = Modifier.offset(x = -(170).dp, y = -(280).dp)
            ) {

                Text(
                    text = volume,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontSize = 14.sp,
                    color = LightPrimary60,
                    style = TextStyle(
                        letterSpacing = 0.25.sp,
                    ),

                    )
            }
        }

        CupSize(
            modifier = Modifier.padding(bottom = 16.dp),
            onSizeSelected = { selectedCupSize = it }
        )

        CoffeeSize(
            onSizeSelected = { coffeeDropTrigger = !coffeeDropTrigger }
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(152.dp)
        ) {
            val coffeeSize = listOf("Low", "Medium", "High")
            coffeeSize.forEach { size ->
                Text(
                    text = size,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontSize = 10.sp,
                    color = LightPrimary60,
                    style = TextStyle(
                        letterSpacing = 0.25.sp,
                    )
                )
            }
        }

        FloatingActionButton(
            text = "Continue",
            icon = painterResource(R.drawable.ic_arrow_right),
            onClick = { onNavigateToLoadingScreen() },
            modifier = Modifier
                .padding(top = 92.dp, bottom = 50.dp)
                .align(Alignment.CenterHorizontally)
        )

    }
}