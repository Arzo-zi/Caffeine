package com.example.caffeine.presentation.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.ui.theme.Brown60
import com.example.caffeine.ui.theme.LightSurface
import com.example.caffeine.ui.theme.DarkSurface
import com.example.caffeine.ui.theme.LightPrimary60
import com.example.caffeine.ui.theme.orangeBrown

@Composable
fun ClickableIcon(
    icon: Any,
    modifier: Modifier = Modifier,
    sizeColor: Color = LightPrimary60,
    isSelected: Boolean = true,
    onClick: () -> Unit,
    size: Int = 48,
) {
    var isClicked by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(
        targetValue = when (icon) {
            is String -> if (isSelected) Brown60 else LightSurface
            else -> LightSurface
        },
        animationSpec = tween(
            durationMillis = 40,
            easing = FastOutSlowInEasing
        )
    )
    val shadowModifier = if (isSelected) {
        Modifier.shadow(
            elevation = 16.dp,
            shape = CircleShape,
            ambientColor = orangeBrown,
            clip = false
        )
    } else {
        Modifier
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size.dp)
            .clip(CircleShape)
            .clickable {
                isClicked = false
                onClick()
            }
            .background(backgroundColor)
            .then(shadowModifier)
    ) {
        when (icon) {
            is Painter -> {
                Icon(
                    painter = icon,
                    contentDescription = "Icon",
                    modifier = Modifier.size(24.dp),
                    tint = DarkSurface
                )
            }

            is String -> {
                Text(
                    text = icon.uppercase(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = sizeColor,
                    style = TextStyle(
                        fontWeight = FontWeight(700),
                        letterSpacing = 0.25.sp
                    )
                )
            }

            else -> {
                Text(
                    text = "?",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkSurface
                )
            }
        }
    }
}