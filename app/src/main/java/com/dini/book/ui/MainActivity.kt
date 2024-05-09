package com.dini.book.ui

import AboutScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dini.book.ui.components.BottomBar
import com.dini.book.ui.navigation.Screen
import com.dini.book.ui.screen.book.DataScreen
import com.dini.book.ui.screen.detail.DetailScreen
import com.dini.book.ui.screen.home.HomeScreen
import com.dini.book.ui.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailBooks.route) {
                BottomBar(navController)
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { booksId ->
                        navController.navigate(Screen.DetailBooks.createRoute(booksId))
                    }
                )
            }
            composable(Screen.Data.route) {
                DataScreen(navigateToDetail = { booksId ->
                    navController.navigate(Screen.DetailBooks.createRoute(booksId))
                })
            }
            composable(Screen.Profile.route) {
                AboutScreen()
            }
            composable(
                Screen.DetailBooks.route,
                arguments = listOf(navArgument("booksId") { type = NavType.IntType }),
            ) {
                DetailScreen(navController)
            }
        }
    }
}

