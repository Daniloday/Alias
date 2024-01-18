package com.missclick.alies.ui.screens.win

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.missclick.alies.R
import com.missclick.alies.ui.components.BigTeamCard
import com.missclick.alies.ui.components.SmallTeamCard
import com.missclick.alies.ui.theme.AppTheme

@Composable
fun WinScreen() {

    val context = LocalContext.current

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = context.getString(R.string.results),
            style = AppTheme.typography.headerTextThin,
            color = AppTheme.colors.primary
        )
        Text(
            text = "${context.getString(R.string.round)} 7",
            style = AppTheme.typography.headerTextThin,
            color = AppTheme.colors.primary
        )

        val list = mutableListOf(
            mutableListOf("Lions", "50"),
            mutableListOf("Lions", "20"),
            mutableListOf("Lions", "30"),
            mutableListOf("Lions", "40"),
            mutableListOf("Lions", "40"),
            mutableListOf("Lions", "40"),
            mutableListOf("Lions", "40"),
            mutableListOf("Lions", "40"),
            mutableListOf("Lions", "40"),
            mutableListOf("Lions", "40")
        )


        LazyColumn(modifier = Modifier.height(300.dp), content = {
            itemsIndexed(list) { i, _ ->

                val word = list[i][1]

                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    SmallTeamCard(teamImage = R.drawable.agama, teamName = list[i][0])

                    Text(
                        text = word,
                        style = AppTheme.typography.roundWordsText,
                        color = AppTheme.colors.primary
                    )

                }
            }
        })

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = context.getString(R.string.congratulations),
                style = AppTheme.typography.roundWordsText,
                color = AppTheme.colors.primary,
                textAlign = TextAlign.Center
            )

            BigTeamCard(teamImage = R.drawable.agama, teamName = "Agamas")

        }

        Text(
            text = context.getString(R.string.tap_to_start_new_game),
            style = AppTheme.typography.teamCardText,
            color = AppTheme.colors.primary,
            textAlign = TextAlign.Center
        )


    }

}