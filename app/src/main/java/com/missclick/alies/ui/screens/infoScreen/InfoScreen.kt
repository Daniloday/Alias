package com.missclick.alies.ui.screens.infoScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.missclick.alies.R
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.theme.AppTheme

@Composable
fun InfoScreen(navController: NavHostController) {

    val context = LocalContext.current

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            Modifier
                .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.cross),
                contentDescription = null, modifier = Modifier
                    .size(32.dp)
                    .clickable { navController.navigate(NavigationTree.MENU.name) }
            )
        }



        Card(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .weight(1f)
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
            colors = CardDefaults.cardColors(containerColor = AppTheme.colors.secondaryBackground)
        ) {

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val listOfRules = listOf<String>(
                    context.getString(R.string.rule1),
                    context.getString(R.string.rule2),
                    context.getString(R.string.rule3),
                    context.getString(R.string.rule4),
                    context.getString(R.string.rule5),
                    context.getString(R.string.rule6),
                    context.getString(R.string.rule7)
                )

                LazyColumn(content = {
                    item {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                            Text(
                                text = context.getString(R.string.rules),
                                style = AppTheme.typography.headerTextBold,
                                color = AppTheme.colors.primary
                            )
                        }
                    }
                    itemsIndexed(listOfRules) { _, rule ->
                        Text(
                            text = rule,
                            style = AppTheme.typography.teamCardText,
                            color = AppTheme.colors.primary,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )
                    }
                })


            }


        }

        Row(
            Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = context.getString(R.string.created_by_missclick),
                style = AppTheme.typography.teamCardText,
                color = AppTheme.colors.primary
            )
        }


    }


}