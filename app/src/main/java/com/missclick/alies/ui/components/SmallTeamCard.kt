package com.missclick.alies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.missclick.alies.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTeamCard(teamImage: Int, teamName: String, click : (() -> Unit)? = null) {

    Card(
        modifier = Modifier
            .padding(4.dp)
            .size(128.dp, 48.dp)
            .clickable(click != null) { click?.invoke() },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(containerColor = AppTheme.colors.secondaryBackground),

    ) {

        Row(
            Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = teamImage),
                contentDescription = "team image",
                modifier = Modifier.size(36.dp)
            )
            Text(
                text = teamName,
                style = AppTheme.typography.teamCardText,
                color = AppTheme.colors.primary
            )


        }

    }

}