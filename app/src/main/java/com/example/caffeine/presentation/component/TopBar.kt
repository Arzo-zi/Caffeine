package com.example.caffeine.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    imgProfile: Painter? = null,
    icon: Painter = painterResource(id = R.drawable.ic_add),
    topBarTitle: String? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if (imgProfile != null) {
            Arrangement.SpaceBetween
        } else {
            Arrangement.spacedBy(12.dp)
        },

        ) {
        imgProfile?.let {
            Image(
                painter = painterResource(R.drawable.im_profile),
                contentDescription = "Profile Image",
                modifier = Modifier.size(48.dp)
            )
        }
        PainterIconButton(
            icon = icon,
            onClick = {

                /* TODO */

            },
        )
        topBarTitle?.let {
            Text(
                text = topBarTitle,
                modifier = Modifier,
                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                fontSize = 24.sp,
            )
        }
    }
}

@Preview(
    name = "TopBar Preview", showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
@Composable
private fun TopBarPreview() {
    TopBar(
//        imgProfile = painterResource(id = R.drawable.im_profile),

        topBarTitle = "Top Bar Title",
    )
}