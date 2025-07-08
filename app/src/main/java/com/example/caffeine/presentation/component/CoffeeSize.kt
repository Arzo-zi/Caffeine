package com.example.caffeine.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.Brown60
import com.example.caffeine.ui.theme.LightGray80
import com.example.caffeine.ui.theme.LightSurface
import com.example.caffeine.ui.theme.whiteColor

@Composable
fun CoffeeSize(
    modifier: Modifier = Modifier,
    onSizeSelected: (Int) -> Unit,
) {
    val beansCount = 3
    val coffeeBeans = painterResource(R.drawable.ic_coffee_beans)
    var selectedSize by remember { mutableStateOf<Int?>(null) }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(100.dp))
            .height(56.dp)
            .width(152.dp)
            .background(color = LightGray80)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            repeat(beansCount) { index ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(if (selectedSize == index) Brown60 else LightSurface)
                        .clickable {
                            selectedSize = index
                            onSizeSelected(index)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (selectedSize == index) {
                        Icon(
                            painter = coffeeBeans,
                            contentDescription = "Coffee Bean",
                            modifier = Modifier.size(24.dp),
                            tint = whiteColor
                        )
                    }
                }
            }
        }
    }
}