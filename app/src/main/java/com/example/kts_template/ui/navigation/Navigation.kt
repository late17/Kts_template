package com.example.kts_template.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kts_template.ui.mainscreen.MainScreen
import com.example.kts_template.ui.mainscreen.MainScreenViewModel
import com.example.kts_template.ui.secondscreen.SecondScreen

@Composable
fun Navigation() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = "mainScreen") {
        composable("mainScreen") {
            val viewModel: MainScreenViewModel = hiltViewModel()
            MainScreen(viewModel) { int ->
                navHostController.navigate(
                    route = "secondScreen/$int",
                )
            }
        }
        composable(
            route = "secondScreen/{int}",
            arguments = listOf(
                navArgument("int") {
                    type = NavType.IntType
                }
            )
        ) {
            val int = it.arguments?.getInt("int") ?: -1
            SecondScreen(int)
        }
    }
}