package com.example.to_docompose.navigation

import androidx.navigation.NavHostController
import com.example.to_docompose.utils.Action
import com.example.to_docompose.utils.Constants.LIST_SCREEN

class Screens(navHostController: NavHostController) {
    val list: (Action) -> Unit = { action ->
        navHostController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navHostController.navigate(route = "task/${taskId}")
    }

}