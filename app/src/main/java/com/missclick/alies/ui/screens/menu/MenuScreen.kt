package com.missclick.alies.ui.screens.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.missclick.alies.R
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun MenuScreen(navController: NavController, vm: MenuViewModel = koinViewModel()){
    Box(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter),horizontalArrangement = Arrangement.SpaceBetween){
            Image(painter = painterResource(id = R.drawable.info_button), contentDescription = null, modifier = Modifier.size(56.dp).padding(start = 24.dp,top = 24.dp))
            Image(painter = painterResource(id = R.drawable.ukraine_lang), contentDescription = null, modifier = Modifier.size(56.dp).padding(top = 24.dp,end = 24.dp))
        }
        Image(painter = painterResource(id = R.drawable.play_menu), contentDescription = null,
            modifier = Modifier.size(300.dp).align(Alignment.Center).clip(CircleShape).clickable {
                navController.navigate(NavigationTree.CHOOSE_TEAM.name)
            })
    }
}