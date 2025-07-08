package com.example.caffeine.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.caffeine.ui.theme.LightGray80

@Composable
fun CupSize(
    modifier: Modifier = Modifier,
    onSizeSelected: (String) -> Unit,
) {
    val cupSizeType = listOf("S", "M", "L")
    val activeColors = mapOf("S" to Color.White, "M" to Color.White, "L" to Color.White)
    var selectedSize by remember { mutableStateOf<String?>(null) }

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

            cupSizeType.forEach { size ->
//                val color = if (selectedSize==size) activeColors[size] ?:
                ClickableIcon(
                    icon = size,
                    isSelected = selectedSize==size,
                    onClick = {
                        selectedSize = size
                        onSizeSelected(size)
                    },
                    size = 40,
                )
            }
        }
    }
}