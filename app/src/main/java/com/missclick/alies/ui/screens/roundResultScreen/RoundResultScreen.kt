package com.missclick.alies.ui.screens.roundResultScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.missclick.alies.R
import com.missclick.alies.ui.components.NextButton
import com.missclick.alies.ui.components.RoundScoreGameScreen
import com.missclick.alies.ui.components.TeamImageCard
import com.missclick.alies.ui.components.WordCard
import com.missclick.alies.ui.theme.AppTheme

@Composable
fun RoundResultScreen() {

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


        var list = mutableListOf(
            mutableListOf("Snake", "true"),
            mutableListOf("Snake", "true"),
            mutableListOf("Snake", "true"),
            mutableListOf("Snake", "true"),
            mutableListOf("Snake", "true"),
            mutableListOf("Snake", "true"),
            mutableListOf("Snake", "true"),
            mutableListOf("Snake", "true"),
            mutableListOf("Snake", "true"),
            mutableListOf("Snake", "true"),
            mutableListOf("Snake", "true"),
            mutableListOf("Snake", "true"),
            mutableListOf("Snake", "true")
        )


        LazyColumn(modifier = Modifier.height(300.dp),content = {
            itemsIndexed(list) { i, _ ->

                val word = list[i][0]

                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = word,
                        style = AppTheme.typography.roundWordsText,
                        color = AppTheme.colors.primary
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.check),
                        contentDescription = "check",
                        tint = if (list[i][1] == "true") AppTheme.colors.primary else AppTheme.colors.primaryShadow,
                        modifier = Modifier
                            .size(40.dp)
                            .clickable {

                            }
                    )


                }
            }
        })


        Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = AppTheme.colors.primary)

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "8",
                style = AppTheme.typography.roundCardText,
                color = AppTheme.colors.primary
            )

        }

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