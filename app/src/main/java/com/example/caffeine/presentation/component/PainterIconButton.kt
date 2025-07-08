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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.caffeine.ui.theme.DarkSurface
import com.example.caffeine.ui.theme.LightSurface
import com.example.caffeine.ui.theme.orangeBrown

@Composable
fun PainterIconButton(
    icon: Painter,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onClick: () -> Unit,
    size: Int = 48,
) {
    val backgroundColor by animateColorAsState(
        targetValue = LightSurface,
        animationSpec = tween(40, easing = FastOutSlowInEasing),
        label = "painterBackground"
    )

    val shadowModifier = if (isSelected) {
        Modifier.shadow(16.dp, CircleShape, ambientColor = orangeBrown, clip = false)
    } else Modifier

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size.dp)
            .clip(CircleShape)
            .clickable { onClick() }
            .background(backgroundColor)
            .then(shadowModifier)
    ) {
        Icon(
            painter = icon,
            contentDescription = "Painter Icon",
            modifier = Modifier.size(24.dp),
            tint = DarkSurface
        )
    }
}
