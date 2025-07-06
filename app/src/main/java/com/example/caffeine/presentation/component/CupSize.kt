package com.example.caffeine.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.caffeine.ui.theme.LightGray80

@Composable
fun CupSize(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val cupSizeType = listOf("S", "M", "L")
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
                .padding(horizontal = 32.dp)
                .align(Alignment.Center)
        ) {

            repeat(cupSizeType.size) {
                ClickableIcon(
                    icon = cupSizeType[it],
                    onClick = { onClick() },
                    size = 40,
                )
            }
        }
    }
}