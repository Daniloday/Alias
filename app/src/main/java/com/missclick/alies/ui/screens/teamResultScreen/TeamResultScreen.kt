package com.missclick.alies.ui.screens.teamResultScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.missclick.alies.R
import com.missclick.alies.data.models.Team
import com.missclick.alies.ui.components.NextButton
import com.missclick.alies.ui.components.SmallTeamCard
import com.missclick.alies.ui.screens.teamResultScreen.models.TeamResultScoreEvent
import com.missclick.alies.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun TeamResultScreen(navController: NavController, vm: TeamResultScreenViewModel = koinViewModel()) {

    val context = LocalContext.current
    val viewState by vm.state.collectAsState()


    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "${context.getString(R.string.results)}",
            style = AppTheme.typography.headerTextThin,
            color = AppTheme.colors.primary
        )

        LazyColumn(modifier = Modifier.height(300.dp),content = {
            itemsIndexed(viewState.teams) { i, item ->

                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    SmallTeamCard(teamImage = item.image, teamName = item.teamName)

                    Text(
                        text = (item.score).toString(),
                        style = AppTheme.typography.roundWordsText,
                        color = AppTheme.colors.primary
                    )

                }
            }
        })

        Column(
            Modifier.height(150.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NextButton {
                vm.obtainEvent(event = TeamResultScoreEvent.Next(navController = navController))
            }
        }
    }
}