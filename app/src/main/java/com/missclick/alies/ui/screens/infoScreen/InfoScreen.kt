package com.missclick.alies.ui.screens.infoScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.missclick.alies.R
import com.missclick.alies.ui.navigation.NavigationTree

@Composable
fun InfoScreen(navController: NavHostController) {
    Image(
        painter = painterResource(id = R.drawable.info_button),
        contentDescription = null, modifier = Modifier
            .size(48.dp).clip(CircleShape).clickable { navController.navigate(NavigationTree.MENU.name) }
    )
}