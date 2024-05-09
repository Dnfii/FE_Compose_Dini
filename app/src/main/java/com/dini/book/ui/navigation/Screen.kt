package com.dini.book.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Data : Screen("cart")
    object Profile : Screen("profile")
    object DetailBooks : Screen("detail/{booksId}") {
        fun createRoute(booksId: Int) = "detail/$booksId"
    }
}