package com.missclick.alies.ui.screens.chooseTeam

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.missclick.alies.R
import com.missclick.alies.ui.components.BigTeamCard
import com.missclick.alies.ui.components.NextButton
import com.missclick.alies.ui.components.SmallTeamCard
import com.missclick.alies.ui.theme.AppTheme

@Composable
fun ChooseTeamScreen(){
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()){

        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){

            Text(text = context.getString(R.string.choose_team),style = AppTheme.typography.headerTextBold, modifier = Modifier.padding(top = 8.dp) ,color = AppTheme.colors.primary)

            val choseTeamList = mutableListOf(
                "Lions",
                "Lions",
                "Lions",
                "Lions"
            )

            val teamList = mutableListOf(
                "Lions",
                "Lions",
                "Lions",
                "Lions"
            )


            LazyRow(content = {
                itemsIndexed(choseTeamList){
                        index, item ->

                    SmallTeamCard(teamImage = R.drawable.agama, teamName = item)

                }
            })

            Divider(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp), color = AppTheme.colors.primary)

            LazyColumn(content = {
                itemsIndexed(teamList){
                        index, item ->

                    BigTeamCard(teamImage = R.drawable.capybara, teamName = item)

                }
            })

        }

        Box (modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 24.dp)){
            NextButton()
        }

    }



}