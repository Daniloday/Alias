package com.missclick.alies.ui.screens.gameSettingsScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.missclick.alies.R
import com.missclick.alies.ui.components.NextButton
import com.missclick.alies.ui.components.TriangleArrow
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.screens.chooseTeam.ChooseTeamViewModel
import com.missclick.alies.ui.screens.chooseVocabulary.models.ChooseVocabularyEvent
import com.missclick.alies.ui.screens.gameSettingsScreen.models.GameSettingsEvent
import com.missclick.alies.ui.theme.AppTheme
import com.missclick.alies.ui.theme.AppTheme.colors
import org.koin.androidx.compose.koinViewModel

@Composable
fun GameSettingsScreen(navController: NavController, vm: GameSettingsViewModel = koinViewModel()) {

    val context = LocalContext.current
    val viewState by vm.state.collectAsState()

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = context.getString(R.string.game_settings),
            style = AppTheme.typography.headerTextBold,
            color = AppTheme.colors.primary,
            modifier = Modifier.padding(top = 8.dp)
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp), color = AppTheme.colors.primary
        )

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                Modifier
                    .fillMaxWidth(0.8f)
                    .clip(RoundedCornerShape(20.dp))
                    .background(AppTheme.colors.secondaryBackgroundShadow),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = context.getString(R.string.time),
                    style = AppTheme.typography.headerTextBold,
                    color = AppTheme.colors.primary
                )
                Row(
                    modifier = Modifier
                        .padding(vertical = 8.dp).padding(horizontal = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TriangleArrow(modifier = Modifier
                        .size(30.dp)
                        .rotate(-90f),
                        enable = viewState.timeBooleanLess,
                        click = { vm.obtainEvent(GameSettingsEvent.ChangeTime(false))}
                    )

                    Text(
                        text = "${viewState.timeGameSettings}",
                        style = AppTheme.typography.headerTextThin,
                        color = AppTheme.colors.primary,
                        modifier = Modifier.padding(horizontal = 48.dp)
                    )

                    TriangleArrow(modifier = Modifier
                        .size(30.dp)
                        .rotate(90f),
                        enable = viewState.timeBooleanMore,
                        click = { vm.obtainEvent(GameSettingsEvent.ChangeTime(true))}
                    )

                }
            }


            Column(
                Modifier
                    .fillMaxWidth(0.8f)
                    .clip(RoundedCornerShape(20.dp))
                    .background(AppTheme.colors.secondaryBackgroundShadow),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = context.getString(R.string.goals),
                    style = AppTheme.typography.headerTextBold,
                    color = AppTheme.colors.primary
                )
                Row(
                    modifier = Modifier
                        .padding(vertical = 8.dp).padding(horizontal = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    TriangleArrow(modifier = Modifier
                        .size(30.dp)
                        .rotate(-90f),
                        enable = viewState.goalBooleanLess,
                        click = { vm.obtainEvent(GameSettingsEvent.ChangeGoal(false))}
                    )

                    Text(
                        text = "${viewState.goalGameSettings}",
                        style = AppTheme.typography.headerTextThin,
                        color = AppTheme.colors.primary,
                        modifier = Modifier.padding(horizontal = 48.dp)
                    )

                    TriangleArrow(modifier = Modifier
                        .size(30.dp)
                        .rotate(90f),
                        enable = viewState.goalBooleanMore,
                        click = { vm.obtainEvent(GameSettingsEvent.ChangeGoal(true))}
                    )

                }
            }
        }


        Column(
            Modifier.height(150.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NextButton() {
                vm.obtainEvent(GameSettingsEvent.Next)
                navController.navigate(NavigationTree.PREPARE_FOR_GAME.name)
            }

        }


    }

}