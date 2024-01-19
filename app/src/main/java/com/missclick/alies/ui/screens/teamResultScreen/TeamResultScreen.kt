package com.missclick.alies.ui.screens.teamResultScreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.missclick.alies.R
import com.missclick.alies.data.models.Team
import com.missclick.alies.ui.components.BigTeamCard
import com.missclick.alies.ui.components.NextButton
import com.missclick.alies.ui.components.SmallTeamCard
import com.missclick.alies.ui.screens.teamResultScreen.models.TeamResultScoreEvent
import com.missclick.alies.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun TeamResultScreen(navController: NavController, vm: TeamResultScreenViewModel = koinViewModel()) {

    val context = LocalContext.current
    val viewState by vm.state.collectAsState()

    BackHandler {

    }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${context.getString(R.string.results)}",
            style = AppTheme.typography.headerTextBold,
            modifier = Modifier.padding(top = 8.dp),
            color = AppTheme.colors.primary
        )
        Divider(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .fillMaxWidth()
                .height(1.dp), color = AppTheme.colors.primary
        )

        LazyColumn(modifier = Modifier.weight(1f).height(300.dp), verticalArrangement = Arrangement.Center,content = {
            itemsIndexed(viewState.teams) { i, item ->

                Row(
                    Modifier.padding(horizontal = 30.dp, vertical = 16.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
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

        if(viewState.winner!=null){
            Column(modifier = Modifier.weight(1f),verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = context.getString(R.string.congratulations),
                    style = AppTheme.typography.roundWordsText,
                    color = AppTheme.colors.primary,
                    textAlign = TextAlign.Center
                )

                BigTeamCard(teamImage = viewState.winner!!.image, teamName = viewState.winner!!.teamName)

                Text(
                    modifier = Modifier.clickable {
                        vm.obtainEvent(event = TeamResultScoreEvent.NewGame(navController = navController))
                    },
                    text = context.getString(R.string.tap_to_start_new_game),
                    style = AppTheme.typography.teamCardText,
                    color = AppTheme.colors.primary,
                    textAlign = TextAlign.Center
                )
            }
        }
        else{
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
}