package com.missclick.alies.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.missclick.alies.ui.screens.chooseTeam.ChooseTeamScreen
import com.missclick.alies.ui.screens.chooseVocabulary.ChooseVocabularyScreen
import com.missclick.alies.ui.screens.menu.MenuScreen

@Composable
fun Navigation(){

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = NavigationTree.CHOOSE_TEAM.name){
        composable(NavigationTree.MENU.name){
            MenuScreen()
        }
        composable(NavigationTree.CHOOSE_TEAM.name){
            ChooseTeamScreen()
        }
        composable(NavigationTree.CHOOSE_VOCABULARY.name){
            ChooseVocabularyScreen()
        }
    }
}