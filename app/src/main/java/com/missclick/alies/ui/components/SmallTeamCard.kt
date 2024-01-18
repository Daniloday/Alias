package com.missclick.alies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.missclick.alies.ui.theme.AppTheme



@Composable
fun SmallTeamCard(teamImage: Int, teamName: String, click: (() -> Unit)? = null) {

    Card(
        modifier = Modifier
            .padding(4.dp)
            .size(196.dp, 48.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable(
                enabled = click != null
            ) { click?.invoke() },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(containerColor = AppTheme.colors.secondaryBackground),

        ) {

        Row(
            Modifier
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = teamImage),
                contentDescription = "team image",
                modifier = Modifier.size(36.dp)
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = teamName,
                style = AppTheme.typography.teamCardText,
                color = AppTheme.colors.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )


        }

    }

}