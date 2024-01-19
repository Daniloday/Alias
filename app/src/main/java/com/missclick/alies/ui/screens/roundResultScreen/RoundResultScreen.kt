package com.missclick.alies.ui.screens.roundResultScreen


import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.missclick.alies.R
import com.missclick.alies.ui.components.NextButton
import com.missclick.alies.ui.screens.roundResultScreen.models.RoundResultScreenEvent
import com.missclick.alies.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun RoundResultScreen(
    navController: NavController,
    vm: RoundResultScreenViewModel = koinViewModel()
) {

    val context = LocalContext.current
    val viewState by vm.state.collectAsState()

    BackHandler {

    }

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

        LazyColumn(modifier = Modifier
            .padding(horizontal = 36.dp)
            .fillMaxWidth()
            .height(300.dp),
            content = {
                itemsIndexed(viewState.roundWords) { i, item ->

                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = if (item.word.length > 13)
                                item.word.replaceRange(
                                    startIndex = 11,
                                    endIndex = item.word.lastIndex + 1,
                                    replacement = "...")
                            else item.word,
                            style = AppTheme.typography.roundWordsText,
                            maxLines = 1,
                            color = AppTheme.colors.primary,
                            modifier = Modifier.sizeIn(maxWidth = 240.dp)
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.check),
                            contentDescription = "check",
                            tint =
                            if (item.guessed) AppTheme.colors.primary
                            else AppTheme.colors.primaryShadow,
                            modifier = Modifier
                                .size(40.dp)
                                .clickable {
                                    vm.obtainEvent(event = RoundResultScreenEvent.ChangeTick(i))
                                }
                        )


                    }
                }
            })


        Divider(
            modifier = Modifier.fillMaxWidth(), thickness = 1.dp,
            color = AppTheme.colors.primary
        )

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = viewState.roundScore.toString(),
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
                vm.obtainEvent(RoundResultScreenEvent.Next(navController))
            }
        }
    }
}