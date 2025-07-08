package com.example.caffeine.presentation.screen

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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.caffeine.ui.theme.LightPrimary60

@Composable
fun LoadingHomeScreen(
    modifier: Modifier = Modifier,
//    onNavigateTo: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(vertical = 16.dp)
            .aspectRatio(
                1f / 2f
            )
    ) {
        val selectedCupSize by remember { mutableStateOf("M") }
        val coffeeDropTrigger by remember { mutableStateOf(false) }
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


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 129.dp, bottom = 218.dp)
        ) {
            this@Column.AnimatedVisibility(
                visible = coffeeDropTrigger,
                enter = slideInVertically(
                    initialOffsetY = { -900 },
                    animationSpec = tween(800, easing = FastOutSlowInEasing)
                ),
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
                painter = painterResource(R.drawable.ic_coffee),
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
                modifier = Modifier.offset(x = -(170).dp, y = -(480).dp)
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


        Image(
            painter = painterResource(R.drawable.almost_done),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(height = 105.dp, width = 202.dp)
//                .padding(top = 100.dp)
        )

    }
}