package com.missclick.alies.ui.screens.gameScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.missclick.alies.R
import com.missclick.alies.ui.components.BigTeamCard
import com.missclick.alies.ui.components.RoundScoreGameScreen
import com.missclick.alies.ui.components.TeamImageCard
import com.missclick.alies.ui.components.WordCard
import com.missclick.alies.ui.theme.AppTheme

@Composable
fun GameScreen() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            TeamImageCard(teamImage = R.drawable.agama)

            Text(
                text = 25.toString(),
                style = AppTheme.typography.headerTextThin,
                color = AppTheme.colors.primary
            )

            RoundScoreGameScreen(scoreRound = 8)
        }

        WordCard(word = "Snake")



        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(100.dp).alpha(0.5f),
                shape = CircleShape,
                colors = CardDefaults.cardColors(containerColor = AppTheme.colors.secondaryBackground)
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "skip".uppercase(),
                        style = AppTheme.typography.teamCardText,
                        color = AppTheme.colors.primary
                    )
                }
            }
            Card(
                modifier = Modifier.size(200.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors(containerColor = AppTheme.colors.secondaryBackground)
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Guessed".uppercase(),
                        style = AppTheme.typography.headerTextBold,
                        color = AppTheme.colors.primary
                    )
                }
            }
        }
    }
}