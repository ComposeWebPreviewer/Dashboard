package site.composepreviewer.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import io.github.taz03.compose.web.navigator.NavController
import io.github.taz03.compose.web.navigator.NavHost
import site.composepreviewer.dashboard.pages.home.Home
import site.composepreviewer.dashboard.pages.login.Login
import site.composepreviewer.dashboard.theme.DashboardTheme

@Composable
fun App() {
    val navController = remember { NavController() }

    DashboardTheme {
        NavHost(navController = navController) {
            route("/") {
                Home()
            }

            route("/login") {
                Login()
            }
        }
    }
}
