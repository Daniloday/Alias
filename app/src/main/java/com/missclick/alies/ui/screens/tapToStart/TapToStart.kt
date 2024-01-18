package com.missclick.alies.ui.screens.tapToStart

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.missclick.alies.ui.components.BigTeamCard
import com.missclick.alies.ui.screens.tapToStart.models.TapToStartEvent
import com.missclick.alies.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TapToStart(navController: NavController, vw : TapToStartViewModel = koinViewModel()) {

    val context = LocalContext.current
    val viewState by vw.state.collectAsState()
    BackHandler {

    }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = "${context.getString(R.string.turn)}",
            style = AppTheme.typography.headerTextThin,
            color = AppTheme.colors.primary
        )

        BigTeamCard(teamImage = viewState.step!!.image, teamName = viewState.step!!.name)

        Card(
            modifier = Modifier.size(300.dp),
            shape = CircleShape,
            colors = CardDefaults.cardColors(containerColor = AppTheme.colors.secondaryBackground),
            onClick = {vw.obtainEvent(TapToStartEvent.Start(navController))}
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "${context.getString(R.string.start)}".uppercase(),
                    style = AppTheme.typography.headerTextBold,
                    color = AppTheme.colors.primary
                )
            }
        }

    }
}