package org.d3if3168.assessment2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.d3if3168.assessment2.database.ContactDatabase
import org.d3if3168.assessment2.ui.screen.DetailScreen
import org.d3if3168.assessment2.ui.screen.MainScreen
import org.d3if3168.assessment2.ui.screen.MainViewModel
import org.d3if3168.assessment2.util.ViewModelFactory

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {

    val context = LocalContext.current
    val db = ContactDatabase.getInstance(context)
    val factory = ViewModelFactory(db.dao)
    val viewModel: MainViewModel = viewModel(factory = factory)

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(route = Screen.Home.route) {
            MainScreen(navController, viewModel)
        }

        composable(route = Screen.AddContact.route) {
            DetailScreen(navController, viewModel)
        }

        composable(route = Screen.DetailContact.route) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
            id?.let {
                DetailScreen(navController, viewModel, it)
            } ?: run {
                DetailScreen(navController, viewModel)
            }
        }

    }
}