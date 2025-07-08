package com.example.caffeine.presentation.screen

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.presentation.component.FloatingActionButton
import com.example.caffeine.presentation.component.TopBar
import com.example.caffeine.ui.theme.darkGray
import com.example.caffeine.ui.theme.deepBlack
import com.example.caffeine.ui.theme.mediumLightGray

@Composable
fun ChooseCoffeeScreen(
    modifier: Modifier = Modifier,
    onNavigateToHomeScreen: () -> Unit
) {
    Column(
        modifier = Modifier.padding(WindowInsets.statusBars.asPaddingValues())
    ) {
        TopBar(
            imgProfile = painterResource(R.drawable.im_profile),
            modifier = Modifier.padding(16.dp),
        )

        WelcomeTitle(modifier.padding(bottom = 56.dp))

        ChooseCoffee()

        FloatingActionButton(
            text = "Continue",
            icon = painterResource(R.drawable.ic_arrow_right),
            onClick = {
                onNavigateToHomeScreen()
            },
            modifier = Modifier
                .padding(top = 200.dp, bottom = 50.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
private fun ChooseCoffee(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState { 4 }
    val images = remember {
        listOf(
            R.drawable.img_black,
            R.drawable.img_latte,
            R.drawable.img_macchiato,
            R.drawable.img_espresso,
        )
    }
    val coffeeType = remember {
        listOf(
            "Black",
            "Latte",
            "Macchiato",
            "Espresso"
        )
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        HorizontalPager(
            pagerState,
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            contentPadding = PaddingValues(horizontal = 95.dp),
        ) { page ->

            val isSelected = page == pagerState.currentPage
            val imageSize by animateDpAsState(
                targetValue = if (isSelected) 244.dp else 150.dp,
                animationSpec = tween(
                    durationMillis = 1200,
                    easing = FastOutSlowInEasing
                )
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(images[page]),
                    contentDescription = "Coffee Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(imageSize)
                )

                Text(
                    text = coffeeType[pagerState.currentPage],
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    fontSize = 32.sp,
                    color = deepBlack,
                    style = TextStyle(letterSpacing = 0.25.sp),
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}


@Composable
private fun WelcomeTitle(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Good Morning",
            fontFamily = FontFamily(Font(R.font.urbanist_bold)),
            fontSize = 36.sp,
            color = mediumLightGray,
            style = TextStyle(
                letterSpacing = 0.25.sp,
            )
        )
        Text(
            text = "Hamsa ☀",
            fontFamily = FontFamily(Font(R.font.urbanist_bold)),
            fontSize = 36.sp,
            color = darkGray,
            style = TextStyle(
                letterSpacing = 0.25.sp,
            )
        )
        Text(
            text = "What would you like to drink today?",
            fontFamily = FontFamily(Font(R.font.urbanist_bold)),
            fontSize = 16.sp,
            color = deepBlack,
            style = TextStyle(
                letterSpacing = 0.25.sp,
            ),
        )
    }
}