package com.missclick.alies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.missclick.alies.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BigTeamCard(teamImage: Int, teamName: String, click: (() -> Unit)? = null) {

    Card(
        modifier = Modifier
            .size(144.dp, 100.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable(
                enabled = click != null
            ) { click?.invoke() },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(containerColor = AppTheme.colors.secondaryBackground),
    ) {

        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = teamImage),
                contentDescription = "team image",
                modifier = Modifier.size(60.dp)
            )
            Text(
                text = teamName,
                style = AppTheme.typography.teamCardText,
                color = AppTheme.colors.primary
            )

        }

    }

}