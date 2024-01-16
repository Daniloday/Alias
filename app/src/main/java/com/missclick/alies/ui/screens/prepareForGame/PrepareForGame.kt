package com.missclick.alies.ui.screens.prepareForGame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.missclick.alies.R
import com.missclick.alies.ui.components.SmallTeamCard
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

        Text(
            text = "Time: 30 sec",
            style = AppTheme.typography.headerTextThin,
            color = AppTheme.colors.primary
        )
        Text(
            text = "Goal: 100 points",
            style = AppTheme.typography.headerTextThin,
            color = AppTheme.colors.primary
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Teams",
                style = AppTheme.typography.headerTextThin,
                color = AppTheme.colors.primary
            )

            val teamList = mutableListOf(
                "Lions",
                "Lions",
                "Lions",
                "Lions",
                "Lions",
                "Lions",
                "Lions",
                "Lions",

            )

            Row {
                LazyColumn(content = {
                    itemsIndexed(teamList){
                        index, item ->
                        SmallTeamCard(teamImage = R.drawable.agama, teamName = "agama")
                    }
                })
            }
        }
    }

    //NEXT BUTTON


}