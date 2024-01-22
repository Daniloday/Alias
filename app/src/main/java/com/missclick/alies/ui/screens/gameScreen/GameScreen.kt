package com.missclick.alies.ui.screens.gameScreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.missclick.alies.R
import com.missclick.alies.ui.components.RoundScoreGameScreen
import com.missclick.alies.ui.components.TeamImageCard
import com.missclick.alies.ui.components.WordCard
import com.missclick.alies.ui.screens.gameScreen.models.GameEvent
import com.missclick.alies.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(navController: NavController, vm: GameViewModel = koinViewModel()) {

    val context = LocalContext.current
    val viewState by vm.state.collectAsState()

    BackHandler {

    }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth()
                    .height(100.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                viewState.imageTeam?.let { TeamImageCard(teamImage = it) }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .size(40.dp),
                        shape = RoundedCornerShape(10.dp),
                        elevation = CardDefaults.cardElevation(20.dp),
                        colors = CardDefaults.cardColors(containerColor = AppTheme.colors.secondaryBackground),
                        onClick = {
                            vm.obtainEvent(GameEvent.Pause)
                        }
                    ) {

                        Row(
                            Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Divider(
                                Modifier
                                    .fillMaxHeight(0.5f)
                                    .width(4.dp), color = AppTheme.colors.primary
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                            Divider(
                                Modifier
                                    .fillMaxHeight(0.5f)
                                    .width(4.dp), color = AppTheme.colors.primary
                            )
                        }

                    }

                    Text(
                        text = "${viewState.leftTime}",
                        style = AppTheme.typography.headerTextThin,
                        color = AppTheme.colors.primary
                    )

                }

                RoundScoreGameScreen(scoreRound = viewState.score)
            }

            WordCard(word = viewState.showedWord)




            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .alpha(0.5f),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = AppTheme.colors.secondaryBackground
                    ),
                    onClick = { vm.obtainEvent(GameEvent.Skip(navController)) }
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            text = context.getString(R.string.skip).uppercase(),
                            style = AppTheme.typography.skipWordText,
                            color = AppTheme.colors.primary,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Card(
                    modifier = Modifier.size(200.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = AppTheme.colors.secondaryBackground
                    ),
                    onClick = { vm.obtainEvent(GameEvent.Guessed(navController)) }
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            text = context.getString(R.string.guessed).uppercase(),
                            style = AppTheme.typography.guessedWordText,
                            color = AppTheme.colors.primary
                        )
                    }
                }
            }
        }

        if (viewState.isPaused) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppTheme.colors.primaryBackgroundShadow),
                contentAlignment = Alignment.Center
            ) {
                AlertDialog(modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .wrapContentHeight()
                    .border(2.dp, AppTheme.colors.accent, RoundedCornerShape(20.dp)),
                    containerColor = AppTheme.colors.primaryBackground,
                    tonalElevation = 10.dp,
                    onDismissRequest = {
                                       vm.obtainEvent(GameEvent.ContinueGame)
                    },
                    text = {
                        Text(
                            text = stringResource(id = R.string.are_you_sure_want_finish),
                            style = AppTheme.typography.smallShowedWordText,
                            textAlign = TextAlign.Center,
                            color = AppTheme.colors.primary,
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    confirmButton = {
                        Button(
                            modifier = Modifier.size(100.dp, 48.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = AppTheme.colors.secondaryBackground),
                            onClick = {
                                vm.obtainEvent(GameEvent.FinishGame(navController))
                            }) {
                            Text(
                                text = stringResource(id = R.string.yes),
                                style = AppTheme.typography.teamCardText,
                                color = AppTheme.colors.primary,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    },
                    dismissButton = {
                        Button(
                            modifier = Modifier.size(100.dp, 48.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = AppTheme.colors.secondaryBackground),
                            onClick = {
                                vm.obtainEvent(GameEvent.ContinueGame)
                            }) {
                            Text(
                                text = stringResource(id = R.string.no),
                                style = AppTheme.typography.teamCardText,
                                color = AppTheme.colors.primary,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                )
            }
        }
    }
}
