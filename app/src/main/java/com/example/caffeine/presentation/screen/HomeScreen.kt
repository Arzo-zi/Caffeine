package com.example.caffeine.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.caffeine.R
import com.example.caffeine.presentation.component.CupSize
import com.example.caffeine.presentation.component.TopBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    topBarTitle: String = "Home",
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(vertical = 16.dp)
        ) {
        TopBar(
            topBarTitle = topBarTitle,
            icon = painterResource(R.drawable.ic_arrow_left),
            modifier = Modifier.padding(16.dp),
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(top = 65.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.im_coffee_cup),
                contentDescription = "",
                modifier = Modifier.size(244.dp).zIndex(0f)
            )
            Image(
                painter = painterResource(R.drawable.img_coffee_logo),
                contentDescription = "",
                modifier = Modifier.size(64.dp).zIndex(1f)
            )
        }

        CupSize {

        }

    }
}