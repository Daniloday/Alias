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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
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
                    .background(AppTheme.colors.secondaryBackgroundShadow),
                contentAlignment = Alignment.Center
            ) {
                AlertDialog(modifier = Modifier.fillMaxWidth(0.9f).height(400.dp),containerColor = AppTheme.colors.primaryBackground,
                    dismissButton = {
                        TextButton(onClick = { println("false") }, modifier = Modifier.size(160.dp, 48.dp), colors = ButtonDefaults.buttonColors(containerColor = AppTheme.colors.secondaryBackground)) {
                            Text(
                                text = "No",
                                style = AppTheme.typography.teamCardText,
                                color = AppTheme.colors.primary,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }, confirmButton = {
                        TextButton(onClick = { println("false") }, modifier = Modifier.size(160.dp, 48.dp), colors = ButtonDefaults.buttonColors(containerColor = AppTheme.colors.secondaryBackground)) {
                            Text(
                                text = "Yes",
                                style = AppTheme.typography.teamCardText,
                                color = AppTheme.colors.primary,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    },
                    title = {
                        Text(
                            text = "Game paused",
                            modifier = Modifier.fillMaxSize(),
                            style = AppTheme.typography.roundWordsText,
                            textAlign = TextAlign.Center,
                            color = AppTheme.colors.primary
                        )},
                    text = {
                        Text(
                            text = "Are you sure want to finish the game?",
                            modifier = Modifier.fillMaxSize(),
                            style = AppTheme.typography.roundWordsText,
                            textAlign = TextAlign.Center,
                            color = AppTheme.colors.primary
                        )
                    }, onDismissRequest = {}
                )

            }
        }
    }
}
