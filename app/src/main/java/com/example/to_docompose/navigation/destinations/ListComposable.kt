package com.example.to_docompose.navigation.destinations

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_docompose.ui.screens.list.ListScreen
import com.example.to_docompose.ui.viewModels.SharedViewModel
import com.example.to_docompose.utils.Action
import com.example.to_docompose.utils.Constants.LIST_ARGUMENT_KEY
import com.example.to_docompose.utils.Constants.LIST_SCREEN
import com.example.to_docompose.utils.Constants.TASK_ARGUMENT_KEY
import com.example.to_docompose.utils.Constants.TASK_SCREEN
import com.example.to_docompose.utils.toAction

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()

        LaunchedEffect(key1 = action) {
            sharedViewModel.action.value = action
            Log.d("Action", action.name)
        }

        ListScreen(navigateToTaskScreen = navigateToTaskScreen, sharedViewModel = sharedViewModel)

    }
}