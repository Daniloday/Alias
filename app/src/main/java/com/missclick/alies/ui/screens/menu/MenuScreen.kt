package com.missclick.alies.ui.screens.menu

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.missclick.alies.R
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.screens.menu.models.MenuScreenEvent
import com.missclick.alies.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun MenuScreen(navController: NavController, vm : MenuViewModel = koinViewModel()) {

    BackHandler {

    }

    val viewState by vm.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxSize()
            .clickable(
                enabled = !viewState.cardClose,
                interactionSource = MutableInteractionSource(),
                indication = null
            ) {
                vm.obtainEvent(MenuScreenEvent.OpenCloseCard)
            }) {

            Image(painter = painterResource(id = R.drawable.play_menu), contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.Center)
                    .clip(CircleShape)
                    .clickable() {
                        if (viewState.cardClose) {
                            navController.navigate(NavigationTree.CHOOSE_TEAM.name)
                        } else {
                            vm.obtainEvent(MenuScreenEvent.OpenCloseCard)
                        }

                    })

            Row(
                modifier = Modifier
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {

                Image(
                    painter = painterResource(id = R.drawable.info_button),
                    contentDescription = null, modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .clickable {
                            if (viewState.cardClose) {
                                navController.navigate(NavigationTree.INFO_SCREEN.name)
                            } else {
                                vm.obtainEvent(MenuScreenEvent.OpenCloseCard)
                            }
                        }
                )


                if (viewState.cardClose) {
                    Card(
                        modifier = Modifier
                            .size(60.dp, 40.dp)
                            .clickable {
                                vm.obtainEvent(MenuScreenEvent.OpenCloseCard)
                            }, shape = RoundedCornerShape(0),
                        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                    ) {

                        Box(Modifier.fillMaxSize()) {
                            Image(
                                painter = painterResource(id = viewState.currentLanguage.image),
                                contentDescription = null, modifier = Modifier
                                    .size(60.dp, 40.dp), contentScale = ContentScale.FillBounds
                            )
                        }

                    }
                } else {

                    Card(
                        modifier = Modifier
                            .width(264.dp)
                            .wrapContentHeight(),
                        shape = RoundedCornerShape(20.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                        colors = CardDefaults.cardColors(containerColor = AppTheme.colors.secondaryBackground)
                    ) {
                        Column(Modifier.fillMaxWidth()) {

                            val listOfCountries = viewState.allLanguages

                            for (countryList in listOfCountries) {
                                Row(
                                    Modifier
                                        .clickable() {
                                            vm.obtainEvent(
                                                MenuScreenEvent.ChangeLanguages(
                                                    countryList.name
                                                )
                                            )
                                        }
                                        .padding(horizontal = 24.dp, vertical = 16.dp)
                                        .fillMaxWidth()

                                ) {
                                    Image(
                                        painter = painterResource(id = countryList.image),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(60.dp, 40.dp),
                                        contentScale = ContentScale.FillBounds
                                    )
                                    Spacer(modifier = Modifier.size(16.dp))
                                    Text(
                                        text = countryList.name,
                                        style = AppTheme.typography.teamCardText,
                                        color = AppTheme.colors.primary
                                    )
                                }
                            }


                        }

                    }


                }


            }


        }
    }
}