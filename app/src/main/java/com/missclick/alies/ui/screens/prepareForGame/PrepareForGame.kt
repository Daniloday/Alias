package com.missclick.alies.ui.screens.prepareForGame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.missclick.alies.R
import com.missclick.alies.ui.components.NextButton
import com.missclick.alies.ui.components.SmallTeamCard
import com.missclick.alies.ui.screens.chooseTeam.ChooseTeamViewModel
import com.missclick.alies.ui.screens.menu.MenuViewModel
import com.missclick.alies.ui.screens.prepareForGame.models.PrepareForGameEvent
import com.missclick.alies.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun PrepareForGame(navController: NavController, vm: PrepareForGameViewModel = koinViewModel()) {

    val context = LocalContext.current
    val viewState by vm.state.collectAsState()

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = "${context.getString(R.string.time)}: ${viewState.selectedTime} ${context.getString(R.string.seconds)}",
            style = AppTheme.typography.headerTextThin,
            color = AppTheme.colors.primary
        )
        Text(
            text = "${context.getString(R.string.goals)}: ${viewState.selectedGoal} ${context.getString(R.string.points)}",
            style = AppTheme.typography.headerTextThin,
            color = AppTheme.colors.primary
        )

        Column(modifier = Modifier.height(380.dp),horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "${context.getString(R.string.teams)}",
                style = AppTheme.typography.headerTextThin,
                color = AppTheme.colors.primary
            )
            
            Spacer(modifier = Modifier.size(16.dp))

            val selectedTeamList = viewState.selectedTeams

            Row {
                LazyColumn(content = {
                    itemsIndexed(selectedTeamList) { _, item ->
                        SmallTeamCard(teamImage = item.image, teamName = item.name)
                    }
                })
            }


        }

        Column(
            Modifier.height(150.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NextButton {
                vm.obtainEvent(event = PrepareForGameEvent.Next(navController = navController))

            }
        }
    }


}