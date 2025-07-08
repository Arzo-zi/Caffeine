package com.example.caffeine.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.DarkSurface
import com.example.caffeine.ui.theme.ShadowOverlay
import com.example.caffeine.ui.theme.IconPrimary

@Composable
fun FloatingActionButton(
    text: String,
    icon: Painter,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},

) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(50.dp))
            .height(56.dp)
            .background(color = DarkSurface)
            .clickable {onClick() }
            .shadow(
                elevation = (-12).dp,
                ambientColor = ShadowOverlay,
                spotColor = ShadowOverlay,
//                shape = RoundedCornerShape(60.dp),
//                clip = true
            )


    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .align(Alignment.Center)
        ) {
            Text(
                text = text,
                color = Color.White,
                modifier = Modifier
            )

            Icon(
                painter = icon,
                contentDescription = null,
                tint = IconPrimary,
                modifier = Modifier
                    .size(24.dp)
                    .background(color = IconPrimary)
            )
        }
    }
}

@Preview(
    name = "FloatingActionButton Preview",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
@Composable
private fun FabPreview() {
    FloatingActionButton(
        text = "bring my coffee",
        icon = painterResource(id = R.drawable.icon),
    )

}