package com.missclick.alies.ui.screens.gameSettingsScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.missclick.alies.R
import com.missclick.alies.ui.components.NextButton
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.screens.chooseTeam.ChooseTeamViewModel
import com.missclick.alies.ui.screens.chooseVocabulary.models.ChooseVocabularyEvent
import com.missclick.alies.ui.screens.gameSettingsScreen.models.GameSettingsEvent
import com.missclick.alies.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun GameSettingsScreen(navController: NavController, vm: GameSettingsViewModel = koinViewModel()) {

    val context = LocalContext.current
    val viewState by vm.state.collectAsState()

    val teamList = mutableListOf(
        "Lions",
        "Lions",
        "Lions",
        "Lions"
    )

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "${context.getString(R.string.game_settings)}",
                style = AppTheme.typography.headerTextBold,
                color = AppTheme.colors.primary
            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp), color = AppTheme.colors.primary
            )
        }

        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${context.getString(R.string.time)}",
                style = AppTheme.typography.headerTextThin,
                color = AppTheme.colors.primary
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = "arrow",
                    modifier = Modifier
                        .size(30.dp)
                        .scale(scaleX = -1f, scaleY = 1f).clickable {
                                                                  vm.obtainEvent(GameSettingsEvent.ChangeTime(false))
                        },
                    tint = AppTheme.colors.primary
                )

                Text(
                    text = "${viewState.timeGameSettings}",
                    style = AppTheme.typography.headerTextThin,
                    color = AppTheme.colors.primary
                )

                Icon(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = "arrow",
                    modifier = Modifier.size(30.dp).clickable {
                        vm.obtainEvent(GameSettingsEvent.ChangeTime(true))
                    },
                    tint = AppTheme.colors.primary
                )
            }
        }


        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${context.getString(R.string.goals)}",
                style = AppTheme.typography.headerTextThin,
                color = AppTheme.colors.primary
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = "arrow",
                    modifier = Modifier
                        .size(30.dp)
                        .scale(scaleX = -1f, scaleY = 1f).clickable {
                            vm.obtainEvent(GameSettingsEvent.ChangeGoal(false))
                        },
                    tint = AppTheme.colors.primary
                )

                Text(
                    text = "${viewState.goalGameSettings}",
                    style = AppTheme.typography.headerTextThin,
                    color = AppTheme.colors.primary
                )

                Icon(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = "arrow",
                    modifier = Modifier.size(30.dp).clickable {
                        vm.obtainEvent(GameSettingsEvent.ChangeGoal(true))
                    },
                    tint = AppTheme.colors.primary
                )
            }
        }




        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NextButton() {
                vm.obtainEvent(GameSettingsEvent.Next)
                navController.navigate(NavigationTree.PREPARE_FOR_GAME.name)
            }

            Spacer(modifier = Modifier.size(24.dp))

        }


    }


}