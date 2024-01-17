package com.missclick.alies.ui.screens.chooseTeam

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
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
import com.missclick.alies.ui.components.NextButton
import com.missclick.alies.ui.components.SmallTeamCard
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.screens.chooseTeam.models.ChooseTeamEvent
import com.missclick.alies.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChooseTeamScreen(navController: NavController, vm: ChooseTeamViewModel = koinViewModel()) {

    val context = LocalContext.current
    val viewState by vm.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Text(
                text = context.getString(R.string.choose_team),
                style = AppTheme.typography.headerTextBold,
                modifier = Modifier.padding(top = 8.dp),
                color = AppTheme.colors.primary
            )

            LazyRow(content = {
                itemsIndexed(viewState.choseTeamList) { _, item ->
                    SmallTeamCard(teamImage = item.image, teamName = item.name) {
                        vm.obtainEvent(ChooseTeamEvent.TeamChoseClick(item))
                    }

                }
            })

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp), color = AppTheme.colors.primary
            )

//            LazyColumn(content = {
//                itemsIndexed(viewState.teamList){
//                        _, item ->
//                    BigTeamCard(teamImage = item.image, teamName = item.name){
//                        vm.obtainEvent(ChooseTeamEvent.TeamAllClick(item))
//                    }
//
//                }
//            })

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp), content = {

                repeat((viewState.teamList.size - 1) / 2 + 1) {
                    item {
                        if (viewState.teamList.isNotEmpty()) {
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                BigTeamCard(
                                    teamImage = viewState.teamList[it * 2].image,
                                    teamName = viewState.teamList[it * 2].name
                                ) {
                                    vm.obtainEvent(ChooseTeamEvent.TeamAllClick(viewState.teamList[it * 2]))
                                }
                                if (it * 2 + 1 != viewState.teamList.size) {
                                    BigTeamCard(
                                        teamImage = viewState.teamList[it * 2 + 1].image,
                                        teamName = viewState.teamList[it * 2 + 1].name
                                    ) {
                                        vm.obtainEvent(ChooseTeamEvent.TeamAllClick(viewState.teamList[it * 2 + 1]))
                                    }
                                }
                            }
                        }
                    }
                }
            })
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            NextButton() {
                vm.obtainEvent(ChooseTeamEvent.Next)
                navController.navigate(NavigationTree.CHOOSE_VOCABULARY.name)
            }
        }

    }


}