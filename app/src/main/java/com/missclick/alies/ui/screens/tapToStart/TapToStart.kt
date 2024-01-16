package com.missclick.alies.ui.screens.tapToStart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.missclick.alies.R
import com.missclick.alies.ui.components.BigTeamCard
import com.missclick.alies.ui.theme.AppTheme

@Composable
fun TapToStart() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = "TURN",
            style = AppTheme.typography.headerTextThin,
            color = AppTheme.colors.primary
        )

        BigTeamCard(teamImage = R.drawable.agama, teamName = "Agama")

        Card(
            modifier = Modifier.size(300.dp),
            shape = CircleShape,
            colors = CardDefaults.cardColors(containerColor = AppTheme.colors.secondaryBackground)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Start".uppercase(),
                    style = AppTheme.typography.headerTextBold,
                    color = AppTheme.colors.primary
                )
            }
        }

    }
}