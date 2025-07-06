package com.example.caffeine.presentation.component

import androidx.compose.animation.animateColorAsState
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.Brown60
import com.example.caffeine.ui.theme.LightSurface
import com.example.caffeine.ui.theme.DarkSurface
import com.example.caffeine.ui.theme.LightPrimary60
import com.example.caffeine.ui.theme.orangeBrown

@Composable
fun ClickableIcon(
    icon: Any,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    size: Int = 48,
) {
    var isClicked by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(
        targetValue = if (isClicked) Brown60 else LightSurface
    )
    val shadowModifier = if (isClicked) {
        Modifier.shadow(
            elevation = 16.dp,
            shape = CircleShape,
            ambientColor = orangeBrown,
            clip = false // allows shadow to extend beyond shape
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
                isClicked = true
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
                    color = LightPrimary60,
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
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = modifier
//            .size(size.dp)
//            .clip(CircleShape)
//            .clickable { onClick() }
//            .background(color = LightSurface)
//    ) {
//        Icon(
//            painter = icon,
//            contentDescription = null,
//            modifier = Modifier.size(24.dp),
//            tint = DarkSurface
//        )
//    }
}

@Preview
@Composable
private fun ClickableIconPreview() {
    ClickableIcon(
        icon = painterResource(id = R.drawable.ic_add),
        onClick = {}
    )
}