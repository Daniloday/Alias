package com.missclick.alies.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.missclick.alies.ui.screens.menu.MenuScreen

@Composable
fun Navigation(){

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = NavigationTree.MENU.name){
        composable(NavigationTree.MENU.name){
            MenuScreen()
        }
        composable(NavigationTree.PREPARE_FOR_GAME.name){

        }
        composable(NavigationTree.TAP_TO_START.name){

        }
        composable(NavigationTree.GAME_SCREEN.name){

        }
        composable(NavigationTree.ROUND_RESULT_SCREEN.name){

        }
        composable(NavigationTree.TEAM_RESULT_SCREEN.name){

        }
        composable(NavigationTree.WIN.name){

        }
    }
}