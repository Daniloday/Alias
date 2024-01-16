package com.missclick.alies.ui.screens.prepareForGame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.missclick.alies.ui.screens.menu.MenuViewModel
import com.missclick.alies.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun PrepareForGame(vm: MenuViewModel = koinViewModel()) {

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(text = "Time: 30 sec", style = AppTheme.typography.headerTextThin, color = AppTheme.colors.primary)

        Column {
            Text(text = "Teams", style = AppTheme.typography.headerTextThin, color = AppTheme.colors.primary)

            val teamList = mutableListOf(
                "Lions",
                "Lions",
                "Lions",
                "Lions"
            )

            if (teamList.size < 5){
                LazyColumn(content = {
                    itemsIndexed(teamList){
                            index, item ->

                        //Team Card

                    }
                })
            } else {
                Row(Modifier.fillMaxWidth()) {
                    LazyColumn(content = {
                        itemsIndexed(teamList){
                                index, item ->

                            //Team Card

                        }
                    })
                    LazyColumn(content = {
                        itemsIndexed(teamList){
                                index, item ->

                            //Team Card

                        }
                    })
                }
            }
        }

        
    }

}