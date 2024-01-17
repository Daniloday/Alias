package com.missclick.alies.ui.screens.teamResultScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.missclick.alies.R
import com.missclick.alies.ui.components.NextButton
import com.missclick.alies.ui.components.SmallTeamCard
import com.missclick.alies.ui.theme.AppTheme

@Composable
fun TeamResultScreen() {

    val context = LocalContext.current

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "${context.getString(R.string.results)}",
            style = AppTheme.typography.headerTextThin,
            color = AppTheme.colors.primary
        )
        Text(
            text = "${context.getString(R.string.round)} 7",
            style = AppTheme.typography.headerTextThin,
            color = AppTheme.colors.primary
        )

        var list = mutableListOf(
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


        LazyColumn(modifier = Modifier.height(300.dp),content = {
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

        Column(
            Modifier.height(150.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NextButton {

            }
        }
    }
}