package com.missclick.alies.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.missclick.alies.ui.screens.chooseTeam.ChooseTeamScreen
import com.missclick.alies.ui.screens.chooseVocabulary.ChooseVocabularyScreen
import com.missclick.alies.ui.screens.gameScreen.GameScreen
import com.missclick.alies.ui.screens.gameSettingsScreen.GameSettingsScreen
import com.missclick.alies.ui.screens.infoScreen.InfoScreen
import com.missclick.alies.ui.screens.menu.MenuScreen
import com.missclick.alies.ui.screens.prepareForGame.PrepareForGame
import com.missclick.alies.ui.screens.roundResultScreen.RoundResultScreen
import com.missclick.alies.ui.screens.tapToStart.TapToStart
import com.missclick.alies.ui.screens.teamResultScreen.TeamResultScreen

@Composable
fun Navigation(){

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = NavigationTree.MENU.name){
        composable(NavigationTree.MENU.name){
            MenuScreen(navHostController)
        }
        composable(NavigationTree.CHOOSE_TEAM.name){
            ChooseTeamScreen(navHostController)
        }
        composable(NavigationTree.CHOOSE_VOCABULARY.name){
            ChooseVocabularyScreen(navHostController)
        }
        composable(NavigationTree.PREPARE_FOR_GAME.name){
            PrepareForGame(navHostController)
        }
        composable(NavigationTree.TAP_TO_START.name){
            TapToStart(navHostController)
        }
        composable(NavigationTree.GAME_SCREEN.name){
            GameScreen(navHostController)
        }
        composable(NavigationTree.ROUND_RESULT_SCREEN.name){
            RoundResultScreen(navHostController)
        }
        composable(NavigationTree.TEAM_RESULT_SCREEN.name) {
            TeamResultScreen(navHostController)
        }
        composable(NavigationTree.GAME_SETTINGS.name){
            GameSettingsScreen(navHostController)
        }
        composable(NavigationTree.INFO_SCREEN.name){
            InfoScreen(navHostController)
        }
    }
}